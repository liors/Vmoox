require 'rubygems'
require 'sinatra'
require 'haml'
require 'mongoid'
require './model/*'
require './main'

run Sinatra::Application
