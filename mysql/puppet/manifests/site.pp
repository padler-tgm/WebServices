class { '::mysql::server':
  root_password           => 'root',
  override_options => { 'mysqld' => { 'max_connections' => '1024', 'bind-address' => '0.0.0.0' } },
  restart          => true,
}

mysql::db { 'Webservice':
  user     => 'web',
  password => 'web',
  host     => '%',
  sql      => '/vagrant/sql/dump.sql',
}