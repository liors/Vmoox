require 'sinatra'
require 'haml'
require 'mongoid'
require 'bson_ext'
require './main'

run Sinatra::Application
