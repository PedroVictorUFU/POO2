#!/usr/bin/python
from http.server import BaseHTTPRequestHandler,HTTPServer
from os import curdir, sep
import psycopg2
import json
import cgi

PORT_NUMBER = 12345

try:
	conn = psycopg2.connect("dbname='AplicacaoPOO2' user='postgres' host='localhost' password=''")
	cur = conn.cursor()
except:
	print ("deu ruim")



#This class will handles any incoming request from
#the browser 
class myHandler(BaseHTTPRequestHandler):
	
	#Handler for the GET requests
	def do_GET(self):
		if self.path=="/":
			self.send_response(200)
			self.send_header('Content-type','text/html')
			self.end_headers()
			self.wfile.write(bytes("Vc nao pois url", 'UTF-8'))
	#Handler for the POST requests
	def do_POST(self):
		if self.path=="/login":
			try:
				length=int(self.headers['content-length'])
				post_body = self.rfile.read(length)
				json_data = json.loads(post_body.decode('utf-8'))
				cur.execute("select senha from usuarios where email = '%s'" % json_data["user"])
				response = cur.fetchall()	
				if response[0][0] == json_data["password"]:
					self.send_response(200)
					self.send_header('Content-type','text/plain')
					self.end_headers()
					self.wfile.write(bytes("true","utf-8"))
				else:
					self.send_response(401)
					self.send_header('Content-type','text/plain')
					self.end_headers()
					self.wfile.write(bytes("false","utf-8"))
			except:
				self.send_response(400)
				self.end_headers()


try:
	#Create a web server and define the handler to manage the
	#incoming request
	server = HTTPServer(('', PORT_NUMBER), myHandler)
	print ('Started httpserver on port ' , PORT_NUMBER)
	
	#Wait forever for incoming htto requests
	server.serve_forever()

except KeyboardInterrupt:
	print ('^C received, shutting down the web server')
	server.socket.close()

