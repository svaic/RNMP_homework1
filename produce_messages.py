import os
import json
import time

from kafka import KafkaProducer
import random

keys = ['A', 'B', 'C', 'D']

producer = KafkaProducer(bootstrap_servers=os.environ['BROKER'], security_protocol="PLAINTEXT")

while True:
    key = keys[random.randint(0, len(keys)-1)]
    value = random.randint(0, 1000)
    record = {
        'key': key,
        'value': value,
        'timestamp': int(time.time() * 1000)
    }

    print(json.dumps(record))
    producer.send(
        topic="sensors",
        value=json.dumps(record).encode("utf-8")
    )
    time.sleep(random.randint(500, 2000) / 1000.0)
