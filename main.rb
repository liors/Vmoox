require 'rubygems'
require 'sinatra'
require 'json'


get '/' do 
  "Hello My App"
end

get '/:name' do 
  "Hello "+params[:name]+"!"
end