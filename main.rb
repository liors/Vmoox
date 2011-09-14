require 'rubygems'
require 'sinatra'
require 'json'
require 'net/http'
require 'uri'

get '/:name' do 
  "Hello "+params[:name]+"!"
  requested_url = "https://api.js-kit.com/v1/search?q=childrenof%3Ahttps%3A%2F%2Fbillguard.com%2Fhttps%253A%252F%252Fprelaunch3.billguard.com%252Fcrowdspot%252F%2F"+
        params[:name]+
        "%2F+state%3AUntouched%2CModeratorApproved+itemsPerPage%3A2+children+state%3AUntouched%2CModeratorApproved&appkey=dev.billguard";
  print get_html_content(requested_url)
end

def get_html_content(requested_url)
  uri = URI.parse(requested_url)
  response = Net::HTTP.get_response(uri)
  return response.body       
end