MONGOHQ::Base.establish_connection!(
  :host     => ENV['MONGOID_HOST'],
  :port => ENV['MONGOID_PORT'],
  :username     => ENV['MONGOID_USERNAME'],
  :password     => ENV['MONGOID_PASSWORD'],
  :database     => ENV['MONGOID_DATABASE']
)