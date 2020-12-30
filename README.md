# MobilePrograming_LectureProject_4A
##  **Présentation**   
Voici une application mobile développée en kotlin. Son but est de créer/connecter des utilisateurs afin de leur montrer une recycler view dont les données sont récupérés en faisant un appel à une API rest.

##  **Elements implémentés**
* Utilisation d’une réelle BDD (Room)
* Design
* Ecran avec une liste d'éléments 
* Appel WebService à une API rest  
* Stockage de données en cache 
* Architecture MVVM
* Clean architecture en trois couches : Presentation, Domain et Data 
* Gitflow

##  **Fonctionnalités**

### D'abord, l'écran de connexion.
Quand on lance l'application, on arrive sur une page de connexion. Différents messages : Error login, ...; s'affichent dépendant des actions non "autorisés" de l'utilisateur.

![Screenshot_20201230-021656_4A_project](https://user-images.githubusercontent.com/62256938/103318606-44048f80-4a2f-11eb-94c9-86187a638a7d.jpg)


![Screenshot_20201230-021650_4A_project](https://user-images.githubusercontent.com/62256938/103318603-42d36280-4a2f-11eb-874f-b3d26a0e2721.jpg)
![Screenshot_20201230-021700_4A_project](https://user-images.githubusercontent.com/62256938/103318607-449d2600-4a2f-11eb-9487-3e27f979c14a.jpg)


Une fois bien connecté, il sera emmené sur une page où il pourra visualiser les nombreux films de la maison d'animation Ghibli : 

![Screenshot_20201230-021846_4A_project](https://user-images.githubusercontent.com/62256938/103318819-defd6980-4a2f-11eb-963d-59e707832e45.jpg)


L'utilisateur peut créer son compte et sera diriger sur la page suivante : 

![Screenshot_20201230-022510_4A_project](https://user-images.githubusercontent.com/62256938/103318821-df960000-4a2f-11eb-8839-f65a2414d33f.jpg)



### Ensuite, l'écran de création de compte.
Dépendant de ses entrées, différents messages lui seront affichés. 

Si le login donné est déjà utilisé par un autre utilisateur : 

![Screenshot_20201230-022521_4A_project](https://user-images.githubusercontent.com/62256938/103318814-dc9b0f80-4a2f-11eb-894b-50d2ebe213aa.jpg)


Si tous les champs n'ont pas été remplis: 

![Screenshot_20201230-022512_4A_project](https://user-images.githubusercontent.com/62256938/103318822-e02e9680-4a2f-11eb-96f2-edb9b685e639.jpg)


Si les mots de passe donnés ne sont pas cohérents : 

![Screenshot_20201230-022543_4A_project](https://user-images.githubusercontent.com/62256938/103318816-de64d300-4a2f-11eb-8a18-c1290b044ae2.jpg)
![Screenshot_20201230-022540_4A_project](https://user-images.githubusercontent.com/62256938/103318815-ddcc3c80-4a2f-11eb-8132-43f7d3392215.jpg)


Enfin une fois bien enregistré, ce message s'affichera et ramènera l'utilisateur à l'écran de connexion. 

![Screenshot_20201230-022559_4A_project](https://user-images.githubusercontent.com/62256938/103318818-de64d300-4a2f-11eb-826e-a450f7fdc134.jpg)



##  **Autres**

Si notre Api call ne réussit pas, un message d'erreur s'affiche: 

![Screenshot_20201230-021830_4A_project](https://user-images.githubusercontent.com/62256938/103318777-c5f4b880-4a2f-11eb-97c7-35823efb68d4.jpg)


L'icône de l'application a été personnalisée : 

![Screenshot_20201230-022343_One UI Home](https://user-images.githubusercontent.com/62256938/103318778-c68d4f00-4a2f-11eb-8649-7452ac7eff04.jpg)








