package com.jcaa.usersmanagement.infrastructure.adapter.persistence.repository;

import com.jcaa.usersmanagement.application.port.out.*;
import com.jcaa.usersmanagement.domain.enums.ProviderStatus;
import com.jcaa.usersmanagement.domain.exception.ProviderNotFoundException;
import com.jcaa.usersmanagement.domain.model.ProviderModel;
import com.jcaa.usersmanagement.domain.valueobject.*;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.exception.PersistenceException;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public final class ProviderRepositoryMySQL implements
        SaveProviderPort,
        UpdateProviderPort,
        GetProviderByIdPort,
        GetProviderByNitPort,
        GetAllProvidersPort,
        DeleteProviderPort {

    private static final String SQL_INSERT =
            "INSERT INTO providers (id, nit, name, email, phone, address, status, created_at, updated_at) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";

    private static final String SQL_UPDATE =
            "UPDATE providers SET nit = ?, name = ?, email = ?, phone = ?, address = ?, status = ?, updated_at = NOW() "
            + "WHERE id = ?";

    private static final String SQL_SELECT_BY_ID =
            "SELECT id, nit, name, email, phone, address, status FROM providers WHERE id = ? LIMIT 1";

    private static final String SQL_SELECT_BY_NIT =
            "SELECT id, nit, name, email, phone, address, status FROM providers WHERE nit = ? LIMIT 1";

    private static final String SQL_SELECT_ALL =
            "SELECT id, nit, name, email, phone, address, status FROM providers ORDER BY created_at DESC";

    private static final String SQL_DELETE =
            "DELETE FROM providers WHERE id = ?";

    private final Connection connection;

    @Override
    public ProviderModel save(final ProviderModel provider) {
        try (final PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
            stmt.setString(1, provider.getId().value());
            stmt.setString(2, provider.getNit().value());
            stmt.setString(3, provider.getName().value());
            stmt.setString(4, provider.getEmail().value());
            stmt.setString(5, provider.getPhone().value());
            stmt.setString(6, provider.getAddress().value());
            stmt.setString(7, provider.getStatus().name());
            stmt.executeUpdate();
            return findByIdOrFail(provider.getId());
        } catch (final SQLException ex) {
            throw PersistenceException.becauseSaveFailed(provider.getId().value(), ex);
        }
    }

    @Override
    public ProviderModel update(final ProviderModel provider) {
        try (final PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE)) {
            stmt.setString(1, provider.getNit().value());
            stmt.setString(2, provider.getName().value());
            stmt.setString(3, provider.getEmail().value());
            stmt.setString(4, provider.getPhone().value());
            stmt.setString(5, provider.getAddress().value());
            stmt.setString(6, provider.getStatus().name());
            stmt.setString(7, provider.getId().value());
            stmt.executeUpdate();
            return findByIdOrFail(provider.getId());
        } catch (final SQLException ex) {
            throw PersistenceException.becauseUpdateFailed(provider.getId().value(), ex);
        }
    }

    @Override
    public Optional<ProviderModel> getById(final ProviderId id) {
        try (final PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_BY_ID)) {
            stmt.setString(1, id.value());
            final ResultSet rs = stmt.executeQuery();
            return rs.next() ? Optional.of(mapRow(rs)) : Optional.empty();
        } catch (final SQLException ex) {
            throw new RuntimeException("Error querying provider by ID", ex);
        }
    }

    @Override
    public Optional<ProviderModel> getByNit(final ProviderNit nit) {
        try (final PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_BY_NIT)) {
            stmt.setString(1, nit.value());
            final ResultSet rs = stmt.executeQuery();
            return rs.next() ? Optional.of(mapRow(rs)) : Optional.empty();
        } catch (final SQLException ex) {
            throw new RuntimeException("Error querying provider by NIT", ex);
        }
    }

    @Override
    public List<ProviderModel> getAll() {
        final List<ProviderModel> list = new ArrayList<>();
        try (final PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL);
             final ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
            return list;
        } catch (final SQLException ex) {
            throw new RuntimeException("Error listing providers", ex);
        }
    }

    @Override
    public void deleteById(final ProviderId id) {
        try (final PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)) {
            stmt.setString(1, id.value());
            stmt.executeUpdate();
        } catch (final SQLException ex) {
            throw new RuntimeException("Error deleting provider", ex);
        }
    }

    private ProviderModel findByIdOrFail(final ProviderId id) {
        return getById(id).orElseThrow(() -> ProviderNotFoundException.becauseIdWasNotFound(id.value()));
    }

    private ProviderModel mapRow(final ResultSet rs) throws SQLException {
        return new ProviderModel(
                new ProviderId(rs.getString("id")),
                new ProviderNit(rs.getString("nit")),
                new ProviderName(rs.getString("name")),
                new ProviderEmail(rs.getString("email")),
                new ProviderPhone(rs.getString("phone")),
                new ProviderAddress(rs.getString("address")),
                ProviderStatus.valueOf(rs.getString("status"))
        );
    }
}