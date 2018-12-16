SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for traincomponent
-- ----------------------------
DROP TABLE IF EXISTS `traincomponent`;
CREATE TABLE `traincomponent` (
  `key` varchar(20) NOT NULL,
  `seats` int(255) NOT NULL DEFAULT '0',
  `train_key` varchar(20) DEFAULT NULL,
  `type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for trains
-- ----------------------------
DROP TABLE IF EXISTS `trains`;
CREATE TABLE `trains` (
  `key` varchar(20) NOT NULL,
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;