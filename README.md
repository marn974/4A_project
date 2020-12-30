# MobilePrograming: LectureProject 4A
##  **Présentation**   
Voici une application mobile développée en kotlin. Son but est de créer/connecter des utilisateurs afin de leur montrer une recycler view dont les données sont récupérés en faisant un appel à une API rest.

##  **Elements implémentés**
* Utilisation d’une réelle BDD (Room)
* Design (CardView, material button, ...)
* Ecran avec une liste d'éléments 
* Appel WebService à une API rest  
* Stockage de données en cache 
* Architecture MVVM
* Clean architecture en trois couches : Presentation, Domain et Data 
* Gitflow

##  **Fonctionnalités**

### D'abord, l'écran de connexion.
Quand on lance l'application, on arrive sur une page de connexion. Différents messages : Error login, ...; s'affichent dépendant des actions non "autorisés" de l'utilisateur. 

![Screenshot_20201230-222348_4A_project](https://user-images.githubusercontent.com/62256938/103374607-51298900-4ad8-11eb-84ef-37ae3bcd4a65.jpg)


![Screenshot_20201230-222408_4A_project](https://user-images.githubusercontent.com/62256938/103374604-4ec72f00-4ad8-11eb-9e9f-b7041ac5fc8b.jpg)
![Screenshot_20201230-222356_4A_project](https://user-images.githubusercontent.com/62256938/103374606-5090f280-4ad8-11eb-943d-780c702cfab6.jpg)

Une fois bien connecté, il sera emmené sur une page où il pourra visualiser les nombreux films de la maison d'animation Ghibli : 

![Screenshot_20201230-221339_4A_project](https://user-images.githubusercontent.com/62256938/103374610-51c21f80-4ad8-11eb-8fa9-0b9d9cddbb16.jpg)

### Ensuite, l'écran de création de compte.
L'utilisateur peut créer son compte et depuis la page de connexion sera dirigé sur la page suivante : 

![Screenshot_20201230-022510_4A_project](https://user-images.githubusercontent.com/62256938/103318821-df960000-4a2f-11eb-8839-f65a2414d33f.jpg)



Dépendant de ses actions, différents messages lui seront affichés. 

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








