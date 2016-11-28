Projet Web à l’attention de Monsieur GARNIER-CASTELLANE,

    Un projet Symfony crée le 19 septembre 2016.

Vous trouverez le site déployé sur le lien suivant : www.esiea.superchouette.io
Veuillez également trouver dans la racine du projet le dossier capture.zip qui contient les captures d’écran certifiant le fonctionnement de notre site web en local.

## Fonctionnalités
Le site propose aux utilisateurs de proposer leur recette et les cuisiner pour des particuliers en échange d’une commission. Le site ESIEA EATS se chargeant de faire l’intermédiaire et de s’occuper de la logistique via des coursiers rémunérés.  

Dans ce but nous avons proposé une page pour ajouter, modifier et supprimer une recette. Et en complément de celles-ci, nous avons également ajouté des pages pour saisir des coordonnées de livraison et de paiement (ces informations sont inscrites dans la base de données au même titre que les recettes).


## Installation

    php composer.phar install

    php bin/console doctrine:database:create

    php bin/console doctrine:schema:update --dump-sql

    php bin/console doctrine:schema:update --force

    php bin/console assets:install web

## Au sujet du déploiement
Le déploiement sur Heroku à été très difficile. Chose encore plus surprenante, sur une réinstallation de Symfony propre, des problèmes subsistaient pendant le déploiement.

Nous avons fait le choix de déployer notre site web sur DigitalOcean. Nous avons pour cela configuré un serveur sous Debian via un accès SSH et en utilisant PuttY. 

## Contributeurs

Daniel POINSIGNON & Cannelle TEISSIER
ESIEA Campus de Paris