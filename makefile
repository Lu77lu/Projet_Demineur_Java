JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(FLAGS) $(CLASSES)

CLASSES = src/Main.java \
		src/Autour.java \
		src/Generateur.java \
		src/ControleurTextField.java \
		src/ControleurBoutonMenu.java \
		src/ControleurFenetre.java \
		src/Cases.java \
		src/Fenetre.java \
		src/Grille.java \
		src/Clics.java \
		src/ControleurSouris.java \

CLASSFILES = src/Main.class \
			src/Autour.class \
			src/Generateur.class \
			src/ControleurTextField.class \
			src/ControleurBoutonMenu.class \
			src/ControleurFenetre.class \
			src/Cases.class \
			src/Fenetre.class \
			src/Grille.class \
			src/Clics.class \
			src/ControleurSouris.class

default: classes

classes: $(CLASSES:.java=.class)

clean: 
	rm -f $(CLASSFILES)
