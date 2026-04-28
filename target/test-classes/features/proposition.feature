Feature: Soumission d'une proposition de projet
  En tant qu'étudiant
  Je veux pouvoir soumettre une proposition de projet via un formulaire en ligne
  Afin de présenter mon sujet, mes objectifs et les technologies envisagées

  Scenario: Soumission réussie d'une proposition
    Given l'étudiant est sur la page "proposition.html"
    When il saisit le sujet "Application de e-commerce"
    And il saisit les objectifs "Développer une plateforme de vente en ligne complète"
    And il saisit les technologies "React, Node.js, MongoDB"
    And il clique sur le bouton "Soumettre la proposition"
    Then un message de succès "Votre proposition a été soumise avec succès !" s'affiche
