require 'rubygems'
require 'sinatra'
require 'haml'
require 'mongoid'
require './model/email'
require './main'

run Sinatra::Application
