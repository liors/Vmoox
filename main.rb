require 'rubygems'
require 'sinatra'
require 'json'

get '/:name' do 
  "Hello "+params[:name]+"!"
end