require 'rubygems'
require 'sinatra'
require 'haml'
require 'mongoid'
require 'json'

configure do
   Mongoid.configure do |config|
    name = "emails_database"
    host = "localhost"
    config.master = Mongo::Connection.new.db(name)
   end
end

get '/' do 
  haml :index
end


get '/api/email' do content_type :json
  email = Email.new(:email => 'foo')
  email.save

  email = Email.all_in()
  email.to_json
  
end

class Email
  include Mongoid::Document
  field :email
end