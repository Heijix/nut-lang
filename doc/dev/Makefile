
.PHONY: build_image run_shell run

build_image:
	docker build \
		-t nut/doc_builder \
		.

run_shell: build_image
	docker run --rm -it \
		-v `pwd`/sphinx:/code \
		nut/doc_builder \
		/bin/bash

run: build_image
	docker run --rm \
		-v `pwd`/sphinx:/code \
		nut/doc_builder

deploy_local: run
	docker run -d -p 8080:80 \
		--name doc_nut \
		-v `pwd`/sphinx/_build/html:/usr/share/nginx/html:ro \
		nginx

remove_deploy:
	docker stop doc_nut
	docker rm doc_nut
