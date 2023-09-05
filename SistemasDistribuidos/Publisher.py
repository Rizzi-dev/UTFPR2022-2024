import pika
import json

# Define your data sources (geolocation, energy, and temperature sensors)
geolocation_data = {"latitude": 40.7128, "longitude": -74.0060}
energy_data = {"energy": 100}
temperature_data = {"temperature": 25}

# Create a connection to RabbitMQ
connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()

# Declare an exchange (a named message routing channel)
channel.exchange_declare(exchange='lightning_data', exchange_type='fanout')

# Publish data to RabbitMQ
channel.basic_publish(exchange='lightning_data', routing_key='geolocation_data', body=json.dumps(geolocation_data))
channel.basic_publish(exchange='lightning_data', routing_key='energy_data', body=json.dumps(energy_data))
channel.basic_publish(exchange='lightning_data', routing_key='temperature_data', body=json.dumps(temperature_data))

print("Sent data to RabbitMQ")

# Close the connection
connection.close()