# Tennis Refactoring Kata

Kata original https://sammancoaching.org/kata_descriptions/tennis.html

## Le scénario

Imaginez que vous travaillez pour une société de conseil et qu'un de vos collègues travaille pour la Tennis Society.
Le contrat porte sur 10 heures de travail facturables et votre collègue a consacré 8,5 heures à y travailler.
Malheureusement, il est maintenant tombé malade. Il dit qu'il a terminé le travail et que tous les tests ont réussi.
Votre patronne vous a demandé de lui succéder.
Elle souhaite que vous passiez environ une heure sur le code afin de pouvoir facturer au client les 10 heures complètes.
Elle vous demande de ranger un peu le code et peut-être de prendre quelques notes afin que vous puissiez donner votre
avis à votre collègue sur le design qu'il a choisi.
Vous devez également vous préparer à parler à votre patron de la valeur de ce travail de refactoring, au-delà des heures
supplémentaires facturables.

## Description

Il existe plusieurs versions de ce kata de refactoring, chacune avec ses propres smells et défis de conception.
Je vous propose de commencer par la première, avec la classe "TennisGame1".
La suite de tests fournie est assez complète et rapide à exécuter.
Vous ne devriez pas avoir besoin de modifier les tests, exécutez-les uniquement souvent lorsque vous refactorez.

Il y a une erreur délibérée dans plusieurs implémentations :
les noms des joueurs sont codés en dur sur « player1 » et « player2 ».
Après avoir refactoré, vous souhaiterez peut-être résoudre ce problème et ajouter des cas de test appropriés pour
prouver que votre correctif fonctionne.

## Description

Le tennis a un système de notation plutôt original, et pour les nouveaux arrivants, il peut être un peu difficile de le
suivre.
La société de tennis vous a engagé pour construire un tableau d'affichage permettant d'afficher le score actuel lors des
matchs de tennis.

Vous pouvez en savoir plus sur les scores de tennis sur Wikipédia, résumés ci-dessous :

1. Une partie est gagnée par le premier joueur à avoir gagné au moins quatre points au total et au moins deux points de
   plus que son adversaire.
2. Le score courant de chaque match est décrit d'une manière propre au tennis : les scores de zéro à trois points sont
   décrits respectivement comme « Zéro », « Quinze », « Trente » et « Quarante ».
   En anglais « Love », « Fifteen », « Thirty », and « Forty »
3. Si au moins trois points ont été marqués par chaque joueur et que les scores sont égaux, le score est « Egalité », en
   anglais « Deuce ».
4. Si au moins trois points ont été marqués par chaque camp et qu'un joueur a un point de plus que son adversaire, le
   score de la partie est « Avantage » pour le joueur en tête.

Il vous suffit de déclarer le score du jeu en cours. Les sets et les matchs ne sont pas pris en compte.
