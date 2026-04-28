Feature: Gestion du panier d'achat
  En tant qu'utilisateur du site de vente
  Je veux ajouter des produits à mon panier
  Afin de préparer ma commande

  @Acceptance
  Scenario: Ajouter un article au panier
    Given l'utilisateur est sur la page "index.html"
    When il clique sur le bouton "Ajouter au panier" du premier produit
    Then le compteur du panier doit afficher "1"