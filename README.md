# Projet de développement — Le Pendu
Auteur : Célestin ENGUENE  
Formation : ESAIP — ING2 — 2025/26   

## But du projet

Réaliser le jeu du pendu en Java en console.
Le programme choisit un mot au hasard dans le fichier words.txt et le joueur doit le deviner
lettre par lettre. Il dispose de 8 tentatives maximum avant de perdre.
Un bonus de sauvegarde des scores avec affichage du top 10 est inclus.

## Structure des fichiers

```
pendu/
├── src/
│   ├── pendu/
│   │   ├── Main.java           point d'entree du programme
│   │   ├── Jeu.java            boucle de jeu et saisies clavier
│   │   ├── Partie.java         etat d'une partie en cours
│   │   ├── Pendu.java          dessin ASCII du pendu (9 etapes)
│   │   ├── Dictionnaire.java   lecture de words.txt et tirage aleatoire
│   │   ├── Scores.java         sauvegarde et affichage du top 10
│   │   └── Util.java           suppression des accents
│   └── resources/
│       └── words.txt           liste de mots embarquee dans le projet
├── words.txt                   copie de la liste de mots a la racine
├── .vscode/
│   ├── launch.json             configuration de lancement VS Code
│   └── settings.json           configuration Java VS Code
└── README.md                   ce fichier
```

## Installation et lancement — etape par etape

### Etape 1 — Telecharger et installer Java

Aller sur https://www.oracle.com/java/technologies/downloads/  
Telecharger le JDK 21 pour votre systeme (Windows, Mac ou Linux).  
Suivre l'installateur jusqu'a la fin.

Pour verifier que Java est bien installe, ouvrir un terminal et taper :

```
java -version
```

Vous devez obtenir quelque chose comme :

```
java version "21.0.x"
```

Si ce n'est pas le cas, redemarrer votre ordinateur et reessayer.

### Etape 2 — Installer Visual Studio Code

Aller sur https://code.visualstudio.com/  
Telecharger et installer VS Code.

### Etape 3 — Installer l'extension Java dans VS Code
Ouvrir VS Code.  
Aller dans l'onglet Extensions (icone avec 4 carres sur la gauche, ou Ctrl+Shift+X).  
Rechercher : Extension Pack for Java  
Cliquer sur Installer.  
Attendre la fin de l'installation puis redemarrer VS Code.

### Etape 4 — Ouvrir le projet

Extraire le fichier ZIP du projet sur votre ordinateur.  
Dans VS Code, aller dans Fichier > Ouvrir le dossier.  
Selectionner le dossier "pendu" qui vient d'etre extrait.  
VS Code va analyser le projet pendant quelques secondes (barre de chargement en bas).  
Attendre que cette analyse soit terminee avant de continuer.

### Etape 5 — Lancer le jeu

Ouvrir le fichier src/pendu/Main.java dans l'explorateur de fichiers a gauche.  
Appuyer sur F5.

Ou bien : cliquer sur le bouton "Run" (triangle) qui apparait au-dessus de la methode main.

Le terminal en bas de VS Code va s'ouvrir et le jeu demarre.

### Au demarrage

```
=== LE PENDU ===

Entrez votre prenom :
```

Le programme attend que vous saisissiez votre prenom et que vous appuyiez sur Entree.

### Debut de partie

```
Le mot a deviner contient 7 lettre(s).

        
        
        
        
        
  ___   
 |   |__
 |      
 |______

Mot    : _ _ _ _ _ _ _
Lettres essayees : aucune
Proposez une lettre :
```

La potence vide s'affiche. Le mot est represente par des tirets bas, un par lettre.

### Bonne lettre

```
Bonne lettre !

Mot    : _ _ _ _ _ _ _  (les lettres trouvees remplacent les tirets)
Lettres essayees : A
```

### Mauvaise lettre

```
Mauvaise lettre. (1/8)
```

Le compteur d'erreurs augmente et le dessin du pendu evolue : d'abord la potence,
puis la corde, puis la tete, le corps, les bras et enfin les jambes.

### Lettre deja proposee

```
Vous avez deja essaye cette lettre.
```

Le compteur ne bouge pas, la lettre n'est pas recomptee.

### Victoire

```
Bravo Thomas ! Vous avez trouve le mot en 2 erreur(s).

--- Top 10 ---
1. Thomas - 65 pts
```

Le score est calcule ainsi : longueur du mot x 10, moins 5 points par erreur.  
Il est sauvegarde dans un fichier scores.txt cree automatiquement a la racine du projet.

### Defaite (8 erreurs atteintes)

```
  ____  
  |  |  
  |  o  
  | /|\ 
  | / \ 
  |___  
 |   |__
 |      
 |______

Perdu Thomas... Le mot etait : TABLEAU
```

Le pendu complet s'affiche et le mot solution est revele.

### Fin de session

```
Voulez-vous rejouer ? (o/n) :
```

Repondre "o" pour lancer une nouvelle partie avec un nouveau mot.  
Repondre "n" pour quitter. Le top 10 des meilleurs scores s'affiche avant la fermeture.

---

## Regles du jeu

- Le programme choisit un mot au hasard parmi plus de 600 mots du fichier words.txt
- Le joueur propose une lettre a la fois
- Seules les lettres de A a Z sont acceptees
- Une lettre deja proposee ne compte pas comme une nouvelle tentative
- 8 erreurs maximum, apres quoi c'est une defaite
- Le mot est gagne quand toutes ses lettres ont ete trouvees

---

## Remarques techniques

Le fichier words.txt est embarque directement dans le projet dans le dossier src/resources/.
Cela evite tout probleme de chemin de fichier selon l'endroit depuis lequel VS Code
lance le programme. Une copie est aussi presente a la racine du projet en secours.

Les mots du fichier contiennent des accents. Le programme les supprime automatiquement
avant de comparer avec la lettre saisie par le joueur, ce qui evite tout probleme
de correspondance entre "e" et "e accent".
