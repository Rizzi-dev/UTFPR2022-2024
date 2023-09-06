import pika
import json

# Definição dos dados de entrada
geolocation_data = {"latitude": 40.7128, "longitude": -74.0060}
date_data = {"hora": 15, "minutos": 45, "segundos":56}
energy_data = {"quantidade de energia": 300}
temperature_data = {"temperatura registrada": 30000}

# Criação da conexão com RabbitMQ
connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()

# Declarando a exchange
channel.exchange_declare(exchange='lightning_data', exchange_type='direct')

# Enviado para o servidor RabbitMQ, declarando cada routing key
channel.basic_publish(exchange='lightning_data', routing_key='geolocation', body=json.dumps(geolocation_data))
channel.basic_publish(exchange='lightning_data', routing_key='energy', body=json.dumps(energy_data))
channel.basic_publish(exchange='lightning_data', routing_key='temperature', body=json.dumps(temperature_data))
channel.basic_publish(exchange='lightning_data', routing_key='date', body=json.dumps(date_data))

print("Enviando para Servidor RabbitMQ")

# Encerrando a conexão
connection.close()