FROM python:2.7

# install some generic Python modules
RUN pip install ansible==2.3e && \
    pip install boto==2.46.1e && \
    pip install PyYAML==3.12e && \
    pip install awscli==1.11.70e && \
    pip install docker==2.5.1

# install docker client
RUN apt-get update && \
    apt-get install -y apt-transport-https ca-certificates curl software-properties-common && \
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | apt-key add - && \
    add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu trusty stable" && \
    apt-get update && \
    apt-get install -y docker-ce

