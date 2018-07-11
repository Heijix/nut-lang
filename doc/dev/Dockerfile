FROM debian

RUN apt-get update &&\
    apt-get install -y \
            python3 \
            python3-pip &&\
    rm -rf /var/lib/apt/lists/

VOLUME ["/code"]
WORKDIR /code

RUN pip3 install sphinx
RUN pip3 install sphinx_rtd_theme

CMD ["make", "html"]
