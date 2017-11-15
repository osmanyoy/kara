package com.training.pool;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ConnectionProxy implements Connection {

	private Connection connection;
	private ConnectionPool connectionPool;

	public ConnectionProxy(final Connection connection, final ConnectionPool connectionPool) {
		this.connection = connection;
		this.connectionPool = connectionPool;
	}

	public <T> T unwrap(final Class<T> iface) throws SQLException {
		return this.connection.unwrap(iface);
	}

	public boolean isWrapperFor(final Class<?> iface) throws SQLException {
		return this.connection.isWrapperFor(iface);
	}

	public Statement createStatement() throws SQLException {
		return this.connection.createStatement();
	}

	public PreparedStatement prepareStatement(final String sql) throws SQLException {
		return this.connection.prepareStatement(sql);
	}

	public CallableStatement prepareCall(final String sql) throws SQLException {
		return this.connection.prepareCall(sql);
	}

	public String nativeSQL(final String sql) throws SQLException {
		return this.connection.nativeSQL(sql);
	}

	public void setAutoCommit(final boolean autoCommit) throws SQLException {
		this.connection.setAutoCommit(autoCommit);
	}

	public boolean getAutoCommit() throws SQLException {
		return this.connection.getAutoCommit();
	}

	public void commit() throws SQLException {
		this.connection.commit();
	}

	public void rollback() throws SQLException {
		this.connection.rollback();
	}

	public void close() throws SQLException {
		this.connectionPool.releaseConnection(this);
	}

	public boolean isClosed() throws SQLException {
		return this.connection.isClosed();
	}

	public DatabaseMetaData getMetaData() throws SQLException {
		return this.connection.getMetaData();
	}

	public void setReadOnly(final boolean readOnly) throws SQLException {
		this.connection.setReadOnly(readOnly);
	}

	public boolean isReadOnly() throws SQLException {
		return this.connection.isReadOnly();
	}

	public void setCatalog(final String catalog) throws SQLException {
		this.connection.setCatalog(catalog);
	}

	public String getCatalog() throws SQLException {
		return this.connection.getCatalog();
	}

	public void setTransactionIsolation(final int level) throws SQLException {
		this.connection.setTransactionIsolation(level);
	}

	public int getTransactionIsolation() throws SQLException {
		return this.connection.getTransactionIsolation();
	}

	public SQLWarning getWarnings() throws SQLException {
		return this.connection.getWarnings();
	}

	public void clearWarnings() throws SQLException {
		this.connection.clearWarnings();
	}

	public Statement createStatement(final int resultSetType, final int resultSetConcurrency) throws SQLException {
		return this.connection.createStatement(resultSetType,
		                                       resultSetConcurrency);
	}

	public PreparedStatement prepareStatement(final String sql, final int resultSetType, final int resultSetConcurrency)
	        throws SQLException {
		return this.connection.prepareStatement(sql,
		                                        resultSetType,
		                                        resultSetConcurrency);
	}

	public CallableStatement prepareCall(final String sql, final int resultSetType, final int resultSetConcurrency)
	        throws SQLException {
		return this.connection.prepareCall(sql,
		                                   resultSetType,
		                                   resultSetConcurrency);
	}

	public Map<String, Class<?>> getTypeMap() throws SQLException {
		return this.connection.getTypeMap();
	}

	public void setTypeMap(final Map<String, Class<?>> map) throws SQLException {
		this.connection.setTypeMap(map);
	}

	public void setHoldability(final int holdability) throws SQLException {
		this.connection.setHoldability(holdability);
	}

	public int getHoldability() throws SQLException {
		return this.connection.getHoldability();
	}

	public Savepoint setSavepoint() throws SQLException {
		return this.connection.setSavepoint();
	}

	public Savepoint setSavepoint(final String name) throws SQLException {
		return this.connection.setSavepoint(name);
	}

	public void rollback(final Savepoint savepoint) throws SQLException {
		this.connection.rollback(savepoint);
	}

	public void releaseSavepoint(final Savepoint savepoint) throws SQLException {
		this.connection.releaseSavepoint(savepoint);
	}

	public Statement createStatement(final int resultSetType, final int resultSetConcurrency,
	        final int resultSetHoldability) throws SQLException {
		return this.connection.createStatement(resultSetType,
		                                       resultSetConcurrency,
		                                       resultSetHoldability);
	}

	public PreparedStatement prepareStatement(final String sql, final int resultSetType, final int resultSetConcurrency,
	        final int resultSetHoldability) throws SQLException {
		return this.connection.prepareStatement(sql,
		                                        resultSetType,
		                                        resultSetConcurrency,
		                                        resultSetHoldability);
	}

	public CallableStatement prepareCall(final String sql, final int resultSetType, final int resultSetConcurrency,
	        final int resultSetHoldability) throws SQLException {
		return this.connection.prepareCall(sql,
		                                   resultSetType,
		                                   resultSetConcurrency,
		                                   resultSetHoldability);
	}

	public PreparedStatement prepareStatement(final String sql, final int autoGeneratedKeys) throws SQLException {
		return this.connection.prepareStatement(sql,
		                                        autoGeneratedKeys);
	}

	public PreparedStatement prepareStatement(final String sql, final int[] columnIndexes) throws SQLException {
		return this.connection.prepareStatement(sql,
		                                        columnIndexes);
	}

	public PreparedStatement prepareStatement(final String sql, final String[] columnNames) throws SQLException {
		return this.connection.prepareStatement(sql,
		                                        columnNames);
	}

	public Clob createClob() throws SQLException {
		return this.connection.createClob();
	}

	public Blob createBlob() throws SQLException {
		return this.connection.createBlob();
	}

	public NClob createNClob() throws SQLException {
		return this.connection.createNClob();
	}

	public SQLXML createSQLXML() throws SQLException {
		return this.connection.createSQLXML();
	}

	public boolean isValid(final int timeout) throws SQLException {
		return this.connection.isValid(timeout);
	}

	public void setClientInfo(final String name, final String value) throws SQLClientInfoException {
		this.connection.setClientInfo(name,
		                              value);
	}

	public void setClientInfo(final Properties properties) throws SQLClientInfoException {
		this.connection.setClientInfo(properties);
	}

	public String getClientInfo(final String name) throws SQLException {
		return this.connection.getClientInfo(name);
	}

	public Properties getClientInfo() throws SQLException {
		return this.connection.getClientInfo();
	}

	public Array createArrayOf(final String typeName, final Object[] elements) throws SQLException {
		return this.connection.createArrayOf(typeName,
		                                     elements);
	}

	public Struct createStruct(final String typeName, final Object[] attributes) throws SQLException {
		return this.connection.createStruct(typeName,
		                                    attributes);
	}

	public void setSchema(final String schema) throws SQLException {
		this.connection.setSchema(schema);
	}

	public String getSchema() throws SQLException {
		return this.connection.getSchema();
	}

	public void abort(final Executor executor) throws SQLException {
		this.connection.abort(executor);
	}

	public void setNetworkTimeout(final Executor executor, final int milliseconds) throws SQLException {
		this.connection.setNetworkTimeout(executor,
		                                  milliseconds);
	}

	public int getNetworkTimeout() throws SQLException {
		return this.connection.getNetworkTimeout();
	}

}
