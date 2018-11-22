JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(FLAGS) $(CLASSES)

CLASSES = Main.java \
		Autour.java \
		Generateur.java \
		ControleurTextField.java \
		ControleurBoutonMenu.java \
		ControleurFenetre.java \
		Cases.java \
		Fenetre.java \
		Grille.java \
		Clics.java \
		ControleurSouris.java \

CLASSFILES = Main.class \
			Autour.class \
			Generateur.class \
			ControleurTextField.class \
			ControleurBoutonMenu.class \
			ControleurFenetre.class \
			Cases.class \
			Fenetre.class \
			Grille.class \
			Clics.class \
			ControleurSouris.class

default: classes

classes: $(CLASSES:.java=.class)

clean: 
	rm -f $(CLASSFILES)
