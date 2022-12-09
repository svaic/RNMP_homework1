#Deriving the latest base image
FROM python:latest

# Any working directory can be chosen as per choice like '/' or '/home' etc
# i have chosen /usr/app/src
WORKDIR /usr/app/src

#to COPY the remote file at working directory in container
COPY produce_messages.py ./

# Now the structure looks like this '/usr/app/src/producer.py'
COPY requirements.txt ./

RUN pip3 install -r requirements.txt

#CMD instruction should be used to run the software
#contained by your image, along with any arguments.

CMD [ "python", "./produce_messages.py"]