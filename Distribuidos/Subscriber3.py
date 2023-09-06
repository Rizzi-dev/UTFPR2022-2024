import pika
import json

def callback(ch, method, properties, body):
    data = json.loads(body)
    print(f"Recebendo dados de Geolocalização e Horário: {data}")

connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()

channel.exchange_declare(exchange='lightning_data', exchange_type='direct')

result = channel.queue_declare(queue='', exclusive=True)
queue_name = result.method.queue

# Bindando a lista para cada routing_key
channel.queue_bind(exchange='lightning_data', queue=queue_name, routing_key='geolocation')
channel.queue_bind(exchange='lightning_data', queue=queue_name, routing_key='date')

print("Esperando pelos dados de Geolocalização e Horário...")
channel.basic_consume(queue=queue_name, on_message_callback=callback, auto_ack=True)

channel.start_consuming()
