/*
 Navicat MySQL Data Transfer

 Source Server         : 000
 Source Server Type    : MySQL
 Source Server Version : 50554
 Source Host           : localhost:3306
 Source Schema         : information_demo

 Target Server Type    : MySQL
 Target Server Version : 50554
 File Encoding         : 65001

 Date: 20/10/2020 17:03:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for details
-- ----------------------------
DROP TABLE IF EXISTS `details`;
CREATE TABLE `details`  (
  `d_id` int(10) NOT NULL AUTO_INCREMENT,
  `d_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `d_price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `d_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `d_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `d_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `d_business` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `d_telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `d_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`d_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of details
-- ----------------------------
INSERT INTO `details` VALUES (1, '莲雾', '135', '海南黑金刚莲雾整箱5斤顺丰现摘新鲜水果热带中大特产', '海南', '热带水果', '彩柔水果专营店', '110', '//img1.360buyimg.com/n6/jfs/t1/129420/7/8799/288660/5f292882E4f6ab674/0d7a963caa0a9609.jpg');
INSERT INTO `details` VALUES (2, '红心火龙果', '14', '广西金都一号红心火龙果当季新鲜热带水果多规格 实惠装 2斤小果(尝鲜装)', '广西', '热带水果', '彩柔水果专营店', '110', '//img13.360buyimg.com/n1/jfs/t1/126269/39/6871/113460/5f0b1688Edef00eda/066ec710dfa0c310.jpg');
INSERT INTO `details` VALUES (3, '红肉菠萝蜜', '89', '越南进口红肉菠萝蜜大树木菠萝新鲜热带水果波罗蜜 3.5kg-5kg精品果', '越南', '热带水果', '婺源生鲜旗舰店', '111', '//img11.360buyimg.com/n1/jfs/t1/114695/12/6662/89671/5ebb76aeEea206b0c/9a419af2c2c15ce4.jpg');
INSERT INTO `details` VALUES (4, '青皮芒果', '60', '越南大青芒青皮芒果 新鲜进口水果京东生鲜 单果400-700g 热带白金煌10斤/5kg大芒果送礼 一级大青芒9斤（单果500g以上）', '越南', '热带水果', '老博士生鲜旗舰店', '112', '//img12.360buyimg.com/n1/jfs/t1/116641/33/19905/184889/5f8147d4E86e27133/21cced8c15adb5d5.jpg');
INSERT INTO `details` VALUES (5, '仙人掌果', '58', '海南新鲜仙人掌果 仙桃 当季热带红肉水果 5斤', '海南', '热带水果', '雨迹官方旗舰店', '113', '//img11.360buyimg.com/n1/jfs/t1/105335/33/16973/126642/5e82a5cbE13736d97/7466f90bee31c187.jpg');
INSERT INTO `details` VALUES (6, '百香果', '20', '广西百香果热带水果鸡蛋果西番莲酸甜现摘现发 2斤大果', '广西', '热带水果', '中国特产·北海馆', '114', '//img13.360buyimg.com/n1/jfs/t1/107752/40/4827/367064/5e250910E1170cfec/66ab09294a4d0370.jpg');
INSERT INTO `details` VALUES (7, '红树莓果', '99', '新鲜怡颗莓树莓鲜果2盒装 红树莓覆盆子水果树莓果稀有热带水果京东生鲜', '云南', '热带水果', '米囹生鲜旗舰店', '115', '//img12.360buyimg.com/n1/jfs/t1/133632/23/12445/378550/5f89154dEf16a1b5b/34cd9f830d2b440d.jpg');
INSERT INTO `details` VALUES (8, '红毛丹', '142', '金腰芒 海南当季红毛丹新鲜水果 毛荔枝肉厚 热带水果 5斤', '海南', '热带水果', '金腰芒旗舰店', '116', '//img10.360buyimg.com/n1/jfs/t1/134321/24/5181/165188/5f1a59abE6fae1681/cb0a1e6b4d707301.jpg');
INSERT INTO `details` VALUES (9, '红心番石榴', '30', '蔬果哆 新鲜水果 广西特产 红心番石榴 芭乐 2.5kg 五斤', '广西', '热带水果', '大道至简水果专营店', '117', '//img12.360buyimg.com/n1/jfs/t1/31105/37/3529/135675/5c764258E289aef04/860e54f0aadcb721.jpg');
INSERT INTO `details` VALUES (10, '山竹', '118', '创晟 泰国进口山竹 热带新鲜水果生鲜山竹 京东生鲜 5斤', '泰国', '热带水果', '创晟果蔬专营店', '118', '//img11.360buyimg.com/n1/jfs/t1/118214/9/522/127647/5e8d8de2Eddccf921/183fd033865467d1.jpg');
INSERT INTO `details` VALUES (11, '皇帝柑', '50', '广西武鸣皇帝柑2020当季现摘皇帝柑桔子蜜桔贡柑水果5斤橘子生鲜柑橘 皇帝柑 大果 共发净重9斤', '广西', '亚热带水果', '邻和生鲜专营店', '119', '//img14.360buyimg.com/n1/jfs/t1/128577/4/14849/151145/5f864f9dE4db872f5/09c63fe7926dbed1.jpg');
INSERT INTO `details` VALUES (12, '青皮蜜桔', '10', '湖北北宜昌青皮蜜桔当季新鲜孕妇水果桔子无籽柑橘早熟薄皮橘子 净果4.5斤以上', '湖北', '亚热带水果', '中国特产·点军馆', '120', '//img13.360buyimg.com/n1/jfs/t1/124466/8/9124/189644/5f2cf684E0eb290f1/d3ccdb90fbca607c.jpg');
INSERT INTO `details` VALUES (13, '黑皮甘蔗', '43', '海南黑皮甘蔗10斤新鲜当季水果清甜多汁糖果杆蔗整箱批发特产', '海南', '亚热带水果', '君乐果蔬专营店', '121', '//img13.360buyimg.com/n1/jfs/t1/113881/15/14113/397139/5f2d45afE3e7a00b1/16e2991cc27da13e.jpg');
INSERT INTO `details` VALUES (14, '绿皮甘蔗', '58', '现货 陶山甘蔗 青皮绿皮甘蔗孕妇新鲜水果当季礼盒装整箱5斤非黑皮 2500g甘蔗普通装', '陶山', '亚热带水果', '虫飞飞生鲜专营店', '122', '//img11.360buyimg.com/n1/jfs/t1/54728/18/14702/552580/5db7cebfEef657fe2/9cf47a842dab70b8.jpg');
INSERT INTO `details` VALUES (15, '李子', '40', '现货果园现摘 四川李子新鲜水果当季整箱脱骨脆红李甜带箱6斤', '四川', '亚热带水果', '巴策（山西）水果专营店', '123', '//img14.360buyimg.com/n1/jfs/t1/146071/5/9269/127199/5f6c6f3bE4420da5b/0327ffbd5d52af77.jpg');
INSERT INTO `details` VALUES (16, '青脆李', '45', '四川青脆李3/5斤脆甜土李子清脆空心脱骨李应季新鲜水果现摘发货3斤中果装', '四川', '亚热带水果', 'Brangdy海鲜旗舰店', '124', '//img10.360buyimg.com/n1/jfs/t1/140548/3/8867/103797/5f66234eE9e4867b5/49cb241bf970b1f1.jpg');
INSERT INTO `details` VALUES (17, '青橄榄', '24', '福州檀香青橄榄 生青果 福建闽侯生橄榄果 孕妇水果 1斤 顺丰陆运', '福州', '亚热带水果', '粤乡甜旗舰店', '125', '//img12.360buyimg.com/n5/jfs/t1/137800/28/3972/275162/5f1fe085E0da007d8/4a2ff2527eed07b5.jpg');
INSERT INTO `details` VALUES (18, '新鲜青橄榄', '11', '新鲜青橄榄果生吃青果孕妇煲汤宝宝水果福建橄榄顺丰 现摘新鲜青橄榄(韵达快递)1斤', '福建', '亚热带水果', '喜乔（山西）水果专营店', '126', '//img12.360buyimg.com/n1/jfs/t1/130788/25/4959/241123/5f159e5fEe1e8d379/4488b1cdacca800a.jpg');
INSERT INTO `details` VALUES (19, '大樱桃', '128', '山东大樱桃进口车厘子京东新鲜水果礼盒进口车厘子樱桃 车厘子樱桃1斤（适合一个人大果)', '山东', '亚热带水果', '代养官方旗舰店', '127', '//img12.360buyimg.com/n1/jfs/t1/135274/21/12301/192306/5f841c8dEae805f04/574ce96701a498ef.jpg');
INSERT INTO `details` VALUES (20, '樱桃树', '68', '十年大苗嫁接樱桃树苗车厘子大樱桃苗乌克兰雷尼树苗盆栽地栽庭院阳台当年结果南方北方种植嫁接果树苗 红灯笼 六年苗结果多多', '山东', '亚热带水果', '农络官方旗舰店', '128', '//img11.360buyimg.com/n1/jfs/t1/154705/28/257/147065/5f64dd5bE48162aa7/ce0fd96d8cdbe46b.jpg');
INSERT INTO `details` VALUES (21, '梨', '20', '新鲜梨子现摘金顶谢花砀山酥梨脆甜贡梨新鲜水果雪梨酥梨香梨 净重 五斤', '河南', '温带水果', '一阔果蔬专营店', '129', '//img13.360buyimg.com/n1/jfs/t1/141550/18/9249/150978/5f6c0336E454c008f/3c6556325d3317c5.jpg');
INSERT INTO `details` VALUES (22, '冰糖梨', '50', '长城果品 精选特级 羊脂秋月·冰糖梨 净重5斤 新鲜水果', '河北', '温带水果', '京东超市', '130', '//img12.360buyimg.com/n1/jfs/t9997/17/1304814930/423893/9f09d006/59df22c7N3bf3d634.jpg');
INSERT INTO `details` VALUES (23, '水蜜桃', '128', '北京平谷大桃12个 单果6两左右 水蜜桃新鲜水果脆甜现摘现发', '北京', '温带水果', '小朱大桃生鲜专营店', '131', '//img13.360buyimg.com/n1/jfs/t1/132124/36/266/192637/5ecb2c16E5934be56/d9fb35e5583082de.jpg');
INSERT INTO `details` VALUES (24, '大毛桃', '28', '蓬馨园果蔬烟台产地水分足多甜秋季大毛桃京东新鲜水果现摘现发坏果包赔5斤10大毛桃 2.5kg', '烟台', '温带水果', '蓬馨园果蔬官方旗舰店', '132', '//img10.360buyimg.com/n1/jfs/t1/116534/33/19853/110643/5f8005eaE99c3d9fe/9284fca01b30e744.jpg');
INSERT INTO `details` VALUES (25, '红富士苹果', '70', '烟台红富士苹果5kg 一级铂金大果 单果230g以上 生鲜 新鲜水果', '烟台', '温带水果', '京东超市', '130', '//img11.360buyimg.com/n1/jfs/t1/89913/18/14611/501012/5e66f576Ef721d521/c1f798e11d02e641.jpg');
INSERT INTO `details` VALUES (26, '苹果', '55', '正宗洛川苹果水果新鲜陕西延安当季红富士10一级脆甜整箱斤带箱应 9斤', '陕西', '温带水果', '巨成生鲜专营店', '133', '//img12.360buyimg.com/n1/jfs/t1/121654/11/1297/120931/5ebb6888E0d9e2a6b/097051b506a441c1.jpg');
INSERT INTO `details` VALUES (27, '红蛇果', '35', '源外 甘肃天水花牛苹果精选10斤装 新鲜红蛇果宝宝辅食水果 中果', '甘肃', '温带水果', '源外水果旗舰店', '134', '//img13.360buyimg.com/n1/jfs/t1/69957/9/13192/206261/5da69229E6a900209/6ea22a16e3e95077.jpg');
INSERT INTO `details` VALUES (28, '冰糖心苹果', '88', '冰糖心苹果新鲜水果10斤大果整箱批当季红富士丑胜正宗新疆阿克苏 9斤 中果', '新疆', '温带水果', '巨成生鲜专营店', '135', '//img13.360buyimg.com/n1/jfs/t1/128825/9/1123/87144/5eba0cbaEd96658cb/6efca02a2dbe0351.jpg');
INSERT INTO `details` VALUES (29, '青提', '119', '阳光玫瑰葡萄/提子 香印青提原箱2kg装 2-3串/箱 新鲜水果', '新疆', '温带水果', '京东超市', '130', '//img13.360buyimg.com/n1/jfs/t1/113933/3/14322/68944/5f2bcfa9Eb79e0060/b124d93912d2bfc8.jpg');
INSERT INTO `details` VALUES (30, '黑无籽葡萄', '30', '夏黑无籽葡萄/提子 1kg装 新鲜水果', '新疆', '温带水果', '京东超市', '130', '//img10.360buyimg.com/n1/jfs/t21583/300/67535224/164227/f1843c40/5af90670Ne92313f1.jpg');

-- ----------------------------
-- Table structure for navbar
-- ----------------------------
DROP TABLE IF EXISTS `navbar`;
CREATE TABLE `navbar`  (
  `n_id` int(10) NOT NULL AUTO_INCREMENT,
  `n_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `n_sort` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`n_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of navbar
-- ----------------------------
INSERT INTO `navbar` VALUES (1, '热带水果', 1);
INSERT INTO `navbar` VALUES (2, '亚热带水果', 2);
INSERT INTO `navbar` VALUES (3, '温带水果', 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `u_id` int(25) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_delete` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1',
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`(`u_id`, `username`, `password`, `type`, `is_delete`) VALUES (1, 'admin', 'admin', 'administor', '1');
INSERT INTO `user`(`u_id`, `username`, `password`, `type`, `is_delete`) VALUES (2, 'zs', '123456', 'customer', '1');
INSERT INTO `user`(`u_id`, `username`, `password`, `type`, `is_delete`) VALUES (3, 'ls', '112233', 'store', '1');

SET FOREIGN_KEY_CHECKS = 1;
