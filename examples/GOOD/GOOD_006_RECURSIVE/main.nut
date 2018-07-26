Data Recursive :=
    - string: path
    - bool: true
    - Recursive: absurd

Recursive {
	path : "oui.txt"
	true : false
	absurd : Recursive {
		path : "oui2.txt"
		true : true
		absurd : null
	}
}
