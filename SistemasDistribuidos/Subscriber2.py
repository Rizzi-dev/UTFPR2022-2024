import pika
import json

def callback(ch, method, properties, body):
    data = json.loads(body)
    print(f"Received energy/temperature data: {data}")

connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()

channel.exchange_declare(exchange='lightning_data', exchange_type='fanout')

result = channel.queue_declare(queue='', exclusive=True)
queue_name = result.method.queue

channel.queue_bind(exchange='energy_data', queue=queue_name,routing_key='energy_data')

print("Waiting for energy/temperature data...")
channel.basic_consume(queue=queue_name, on_message_callback=callback, auto_ack=True)

channel.start_consuming()
