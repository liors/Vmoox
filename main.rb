require 'rubygems'
require 'sinatra'
require 'haml'
require 'sass'

get '/' do 
  haml :index
end

get '/:name' do 
  "Hello "+params[:name]+"!"
end