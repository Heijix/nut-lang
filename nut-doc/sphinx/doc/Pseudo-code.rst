Pseudo Code
===========

Here is a pseudo code content.

.. code-block:: none

	func Nut(File f) {
		# Here we have three lists :
		#	- list of imports
		#	- list of data definitions and data aliases
		#	- list of data declarations
		let l_imports, l_definitions, l_datas = Nut.parse(f);

		# Here we defined two lists, two super lists that we will use.
		# We set explicitly a root as null
		let l_table_definition = {}
		let l_table_datas = {root: null}

		# Here we defined a list of imported files.
		# If we imports a file twice, the second time we will see that
		# the file it's already in l_tables_files, so we will not parse it again
		let l_tables_files = [f]

		Nut.handle_imports(l_imports, l_table_definition, l_table_datas, l_tables_files)
		Nut.handle_content_file(l_definitions, l_datas, l_table_definition, l_table_datas)

		return Nut._build_root(l_table_datas)
	}

	func Nut.handle_imports(l_imports, l_table_definition, l_table_datas, l_tables_files) {
		for (import : l_imports) {
			if import is l_tables_files[0] {
				# We cannot import the original file
				crash
			}
			else if import not in l_tables_files {
				l_tables_files.append(import)
				Nut.handle_file(import, l_table_definition, l_table_datas, l_tables_files)
			}
		}
	}

	func Nut.handle_file(import, l_table_definition, l_table_datas, l_tables_files) {
		# Here are lexing, parsing the current file
		let l_imports, l_definitions, l_datas = Nut.parse(f);

		Nut.handle_imports(l_imports, l_table_definition, l_table_datas, l_table_definition)
		Nut.handle_content_file(l_definitions, l_datas, l_table_definition, l_table_datas)
	}

	func Nut.handle_content_file(l_definitions, l_datas, l_table_definition, l_table_datas) {
		# Adding definitions to the super definition list
		for (definition : l_definitions) {
			if (definition is in l_table_definition) {
				# We cannot overwrite an existing declared Data defintion
				# Or aliases
				crash
			}
			l_definitions.append(definition)
		}

		# Checking if l_datas is consistent
		Nut._check_all_references_are_different(l_datas)

		# Checking is there is more than one declared root
		let nb_root = 0
		let nb_non_root_non_ref = 0
		let root_data = null
		for (data : l_datas) {
			if (data is root) {
				nb_root += 1
			}
			else if (data is not root and data is not reference) {
				nb_non_root_non_ref += 1
			}
		}
		if (nb_root > 1) {
			# We don't allow multiple root datas in the same file
			crash
		}
		else if (nb_non_root_non_ref > 1) {
			# We don't allow multiple undeclared datas
			crash
		}
		else if (nb_non_root_non_ref = 1 ans nb_root = 1) {
			# We can't have a declared root and non_type declared data
			crash
		}

		if (nb_root = 1) {
			root_data = Nut._search_root_declared(l_datas)
		}
		else if (nb_non_root_non_ref = 1) {
			root_data = Nut._search_non_root_non_ref(l_datas)
		}

		if (root_data != null) {
			# Replace the previous cached root data.
			Nut._replace_root(l_table_datas, root_data)
		}

		for (data : l_datas) {
			if (data is ref) {
				Nut._add_or_replace_ref(l_table_definition, data)
			}
		}
	}
