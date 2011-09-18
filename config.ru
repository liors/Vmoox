require 'rubygems'
require 'bundler'
require 'sinatra'
require 'haml'
require 'mongoid'
require 'bson_ext'

Bundler.require

require './main'

run Sinatra::Application
