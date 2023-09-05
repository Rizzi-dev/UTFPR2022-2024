import pika
import json

def callback(ch, method, properties, body):
    data = json.loads(body)
    print(f"Received geolocation data: {data}")

connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()

channel.exchange_declare(exchange='lightning_data', exchange_type='fanout')

result = channel.queue_declare(queue='', exclusive=True)
queue_name = result.method.queue

channel.queue_bind(exchange='lightning_data', queue=queue_name, routing_key='geolocation_data')

print("Waiting for geolocation data...")
channel.basic_consume(queue=queue_name, on_message_callback=callback, auto_ack=True)

channel.start_consuming()
