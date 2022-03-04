-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Hôte : db:3306
-- Généré le : ven. 25 fév. 2022 à 16:12
-- Version du serveur : 5.7.37
-- Version de PHP : 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `app_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `cagnotte`
--

DROP TABLE IF EXISTS `cagnotte`;
CREATE TABLE `cagnotte` (
  `id` bigint(20) NOT NULL,
  `date_creation` date DEFAULT NULL,
  `est_favorite` bit(1) NOT NULL,
  `nom` varchar(150) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `cagnotte`
--

INSERT INTO `cagnotte` (`id`, `date_creation`, `est_favorite`, `nom`) VALUES
(1, '2022-01-01', b'1', 'TDC 2022'),
(2, '2021-01-01', b'0', 'TDC 2021');

-- --------------------------------------------------------

--
-- Structure de la table `contrat`
--

DROP TABLE IF EXISTS `contrat`;
CREATE TABLE `contrat` (
  `id` bigint(20) NOT NULL,
  `initiale` varchar(6) NOT NULL,
  `nom` varchar(150) NOT NULL,
  `points` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `contrat`
--

INSERT INTO `contrat` (`id`, `initiale`, `nom`, `points`) VALUES
(1, 'P', 'Petite', 20),
(2, 'G', 'Garde', 50),
(3, 'GS', 'Garde-Sans', 100),
(4, 'GC', 'Garde-Contre', 200),
(5, 'CLM', 'Chelem', 500),
(6, '🇧🇪', '🇧🇪 Belge', 0);

-- --------------------------------------------------------

--
-- Structure de la table `copain`
--

DROP TABLE IF EXISTS `copain`;
CREATE TABLE `copain` (
  `id` bigint(20) NOT NULL,
  `image` varchar(150) DEFAULT NULL,
  `nom` varchar(150) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `copain`
--

INSERT INTO `copain` (`id`, `image`, `nom`) VALUES
(1, 'laurent.png', 'Laurent'),
(2, 'base.png', 'Etienne'),
(3, 'dan.png', 'Dan'),
(4, 'base.png', 'JP'),
(5, 'bernard.png', 'Bernard'),
(6, 'base.png', 'Renée');

-- --------------------------------------------------------

--
-- Structure de la table `joueur`
--

DROP TABLE IF EXISTS `joueur`;
CREATE TABLE `joueur` (
  `id` bigint(20) NOT NULL,
  `dette` int(11) NOT NULL,
  `dette_active` bit(1) DEFAULT NULL,
  `est_guest` bit(1) DEFAULT NULL,
  `copain` bigint(20) NOT NULL,
  `reunion` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `partie`
--

DROP TABLE IF EXISTS `partie`;
CREATE TABLE `partie` (
  `id` bigint(20) NOT NULL,
  `chelem_reussi` bit(1) NOT NULL,
  `contrat_reussi` bit(1) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `points` int(11) NOT NULL,
  `appel` bigint(20) DEFAULT NULL,
  `contrat` bigint(20) NOT NULL,
  `petit_au_bout` bigint(20) DEFAULT NULL,
  `preneur` bigint(20) DEFAULT NULL,
  `reunion` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `reunion`
--

DROP TABLE IF EXISTS `reunion`;
CREATE TABLE `reunion` (
  `id` bigint(20) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `nom` varchar(150) NOT NULL,
  `cagnotte` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `cagnotte`
--
ALTER TABLE `cagnotte`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `copain`
--
ALTER TABLE `copain`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `joueur`
--
ALTER TABLE `joueur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKau4mlbbg12sxtk45c6x9gmcid` (`copain`),
  ADD KEY `FKdyxcfxp009b3nj0wnj9cvsf73` (`reunion`);

--
-- Index pour la table `partie`
--
ALTER TABLE `partie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKt4dtrhy0r4sh1y8f71xclegbe` (`appel`),
  ADD KEY `FKo0xf83n8ifpp6mu220wjcbkmn` (`contrat`),
  ADD KEY `FKd2tei3rya506j6rddawjwoyea` (`petit_au_bout`),
  ADD KEY `FKl3j87se49f7y9ejx5vwp1qg7t` (`preneur`),
  ADD KEY `FKs600gxwitmli2640yk3c5a4qc` (`reunion`);

--
-- Index pour la table `reunion`
--
ALTER TABLE `reunion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5977jjudse7huxcbx2idw638l` (`cagnotte`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `cagnotte`
--
ALTER TABLE `cagnotte`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `contrat`
--
ALTER TABLE `contrat`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `copain`
--
ALTER TABLE `copain`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `joueur`
--
ALTER TABLE `joueur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `partie`
--
ALTER TABLE `partie`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `reunion`
--
ALTER TABLE `reunion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
