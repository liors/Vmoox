require 'rubygems'
require 'sinatra'
require 'haml'
require 'mongoid'
require 'json'

configure do
   Mongoid.configure do |config|
    name = 'app998473'
    config.master = Mongo::Connection.from_uri(ENV['MONGOHQ_URL']).db(name)
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