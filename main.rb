require 'rubygems'
require 'sinatra'
require 'json'
require 'net/http'
require 'uri'

get '/:name' do 
  "Hello "+params[:name]+"!"
end