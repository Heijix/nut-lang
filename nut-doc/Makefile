.PHONY: build_image run_shell run deploy_local remove_deploy

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
	docker run -d -p 42420:80 \
		--name doc_nut \
		-v `pwd`/sphinx/_build/html:/usr/share/nginx/html:ro \
		nginx
	@echo "Go to localhost:42420 to see the Nut doc"

remove_deploy:
	docker stop doc_nut
	docker rm doc_nut

update_deploy: remove_deploy deploy_local

clean:
	rm -rf sphinx/_build
