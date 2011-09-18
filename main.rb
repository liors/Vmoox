require 'rubygems'
require 'sinatra'
require 'haml'
require 'mongoid'
require 'json'


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