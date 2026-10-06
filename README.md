# JPU_Prosit5

Exercice de cours Java sur le cycle de vie Maven : application graphique Insane Vehicles, découpée
en modules.

## Contenu

Le projet est dans `InsaneVehicles/` :

- `InsaneVehicles.contract/` : interfaces du modèle, de la vue et du contrôleur
- `InsaneVehicles.model/` : carte, véhicule et éléments mobiles
- `InsaneVehicles.controller/` : contrôleur et gestion des ordres clavier
- `InsaneVehicles.view/` : affichage
- `InsaneVehicles.main/` : point d'entrée

## Stack

Java, Maven multi-modules, Swing.

## Compiler et lancer

```bash
cd InsaneVehicles
mvn clean install
```

## Contexte

Exercice d'école (2020). Même domaine que `JPU_Prosit_4` et `JPU_Blanck_Project`, avec ici la
découpe en modules Maven.
