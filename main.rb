require 'rubygems'
require 'sinatra'
require 'haml'
require 'mongoid'
require 'json'
require 'model/email'

configure do
   Mongoid.configure do |config|
    name = 'app998473'
    config.master = Mongo::Connection.from_uri(ENV['MONGOHQ_URL']).db(name)
    #config.master = Mongo::Connection.new.db(name)
   end
end

get '/' do 
  haml :index
end

get '/effectiveIT' do 
  erb :effectiveIT
end


get '/api/email' do content_type :json
  email = Email.all_in()
  email.to_json
  
end
