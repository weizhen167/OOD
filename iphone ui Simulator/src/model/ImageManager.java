package model;

import javax.swing.ImageIcon;

public class ImageManager {

    private ImageIcon p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13,
            p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26,
            p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38, p39,
            p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50, p51, p52,
            p53, p54, p55, p56, p57, p58, p59, p60, p61, p62, p63, p64, p65,
            p66, p67, p68, p69, p70, p71, p72, p73, p74, p75, p76, p77, p78,
            p79, p80, p81, p82, p83, p84, p85, p86, p87, p88, p89, p90, p91,
            p92, p93, p94, p95, p96, p97, p98, p99, p100, p101, p102, p103,
            p104, p105, p106, p107, p108, p109, p110, p111, p112, p113, p114,
            p115, p116, p117, p118, p119, p120, p121, p122, p123, p124, p125,
            p126, p127, p128, p129, p130, p131, p132, p133, p134, p135, p136,
            p137, p138, p139, p140, p141, p142, p143, p144, p145, p146, p147,
            p148, p149, p150, p151, p152, p153, p154, p155, p156, p157, p158,
            p159, p160, p161, p162, p163, p164, p165, p166, p167, p168, p169,
            p170, p171, p172, p173, p174, p175, p176, p177, p178, p179, p180,
            p181, p182, p183, p184, p185, p186, p187, p188, p189, p190, p191,
            p192, p193, p194, p195, p196, p197, p198, p199, p200, p201, p202,
            p203, p204, p205, p206, p207, p208, p209, p210, p211, p212, p213,
            p214, p215, p216, p217, p218, p219, p220, p221, p222, p223, p224,
            p225, p226, p227, p228, p229, p230, p231, p232, p233, p234, p235,
            p236, p237, p238, p239, p240, p241, p242, p243, p244, p245, p246,
            p247, p248, p249, p250, p251, p252, p253, p254, p255, p256, p257,
            p258, p259, p260, p261, p262, p263, p264, p265, p266, p267, p268,
            p269, p270, p271, p272, p273, p274, p275, p276, p277, p278, p279,
            p280, p281, p282, p283, p284, p285, p286, p287, p288, p289, p290,
            p291, p292, p293, p294, p295, p296, p297, p298, p299, p300, p301,
            p302, p303, p304, p305, p306, p307, p308, p309, p310, p311, p312,
            p313, p314, p315, p316, p317, p318, p319, p320, p321, p322, p323,
            p324, p325, p326, p327, p328, p329, p330, p331, p332, p333, p334,
            p335, p336, p337, p338, p339, p340, p341, p342, p343, p344, p345,
            p346, p347, p348, p349, p350, p351, p352, p353, p354, p355, p356,
            p357, p358, p359, p360, p361, p362, p363, p364, p365, p366, p367,
            p368, p369, p370, p371, p372, p373, p374, p375, p376, p377, p378,
            p379, p380, p381, p382, p383, p384, p385, p386, p387, p388, p389,
            p390, p391, p392, p393, p394, p395, p396, p397, p398, p399, p400,
            p401, p402, p403, p404,p405;

    private static ImageManager instance;

    public static ImageManager getInstance() {
        if (instance == null) {
            return new ImageManager("/");
        }
        return instance;
    }

    private ImageManager(String pathh) {
        p1 = loadImg(pathh + "p1.png");
        p2 = loadImg(pathh + "p2.png");
        p3 = loadImg(pathh + "p3.png");
        p4 = loadImg(pathh + "p4.png");
        p5 = loadImg(pathh + "p5.png");
        p6 = loadImg(pathh + "p6.png");
        p7 = loadImg(pathh + "p7.png");
        p8 = loadImg(pathh + "p8.png");
        p9 = loadImg(pathh + "p9.png");
        p10 = loadImg(pathh + "p10.png");
        p11 = loadImg(pathh + "p11.png");
        p12 = loadImg(pathh + "p12.png");
        p13 = loadImg(pathh + "p13.png");
        p14 = loadImg(pathh + "p14.png");
        p15 = loadImg(pathh + "p15.png");
        p16 = loadImg(pathh + "p16.png");
        p17 = loadImg(pathh + "p17.png");
        p18 = loadImg(pathh + "p18.png");
        p19 = loadImg(pathh + "p19.png");
        p20 = loadImg(pathh + "p20.png");
        p21 = loadImg(pathh + "p21.png");
        p22 = loadImg(pathh + "p22.png");
        p23 = loadImg(pathh + "p23.png");
        p24 = loadImg(pathh + "p24.png");
        p25 = loadImg(pathh + "p25.png");
        p26 = loadImg(pathh + "p26.png");
        p27 = loadImg(pathh + "p27.png");
        p28 = loadImg(pathh + "p28.png");
        p29 = loadImg(pathh + "p29.png");
        p30 = loadImg(pathh + "p30.png");
        p31 = loadImg(pathh + "p31.png");
        p32 = loadImg(pathh + "p32.png");
        p33 = loadImg(pathh + "p33.png");
        p34 = loadImg(pathh + "p34.png");
        p35 = loadImg(pathh + "p35.png");
        p36 = loadImg(pathh + "p36.png");
        p37 = loadImg(pathh + "p37.png");
        p38 = loadImg(pathh + "p38.png");
        p39 = loadImg(pathh + "p39.png");
        p40 = loadImg(pathh + "p40.png");
        p41 = loadImg(pathh + "p41.png");
        p42 = loadImg(pathh + "p42.png");
        p43 = loadImg(pathh + "p43.png");
        p44 = loadImg(pathh + "p44.png");
        p45 = loadImg(pathh + "p45.png");
        p46 = loadImg(pathh + "p46.png");
        p47 = loadImg(pathh + "p47.png");
        p48 = loadImg(pathh + "p48.png");
        p49 = loadImg(pathh + "p49.png");
        p50 = loadImg(pathh + "p50.png");
        p51 = loadImg(pathh + "p51.png");
        p52 = loadImg(pathh + "p52.png");
        p53 = loadImg(pathh + "p53.png");
        p54 = loadImg(pathh + "p54.png");
        p55 = loadImg(pathh + "p55.png");
        p56 = loadImg(pathh + "p56.png");
        p57 = loadImg(pathh + "p57.png");
        p58 = loadImg(pathh + "p58.png");
        p59 = loadImg(pathh + "p59.png");
        p60 = loadImg(pathh + "p60.png");
        p61 = loadImg(pathh + "p61.png");
        p62 = loadImg(pathh + "p62.png");
        p63 = loadImg(pathh + "p63.png");
        p64 = loadImg(pathh + "p64.png");
        p65 = loadImg(pathh + "p65.png");
        p66 = loadImg(pathh + "p66.png");
        p67 = loadImg(pathh + "p67.png");
        p68 = loadImg(pathh + "p68.png");
        p69 = loadImg(pathh + "p69.png");
        p70 = loadImg(pathh + "p70.png");
        p71 = loadImg(pathh + "p71.png");
        p72 = loadImg(pathh + "p72.png");
        p73 = loadImg(pathh + "p73.png");
        p74 = loadImg(pathh + "p74.png");
        p75 = loadImg(pathh + "p75.png");
        p76 = loadImg(pathh + "p76.png");
        p77 = loadImg(pathh + "p77.png");
        p78 = loadImg(pathh + "p78.png");
        p79 = loadImg(pathh + "p79.png");
        p80 = loadImg(pathh + "p80.png");
        p81 = loadImg(pathh + "p81.png");
        p82 = loadImg(pathh + "p82.png");
        p83 = loadImg(pathh + "p83.png");
        p84 = loadImg(pathh + "p84.png");
        p85 = loadImg(pathh + "p85.png");
        p86 = loadImg(pathh + "p86.png");
        p87 = loadImg(pathh + "p87.png");
        p88 = loadImg(pathh + "p88.png");
        p89 = loadImg(pathh + "p89.png");
        p90 = loadImg(pathh + "p90.png");
        p91 = loadImg(pathh + "p91.png");
        p92 = loadImg(pathh + "p92.png");
        p93 = loadImg(pathh + "p93.png");
        p94 = loadImg(pathh + "p94.png");
        p95 = loadImg(pathh + "p95.png");
        p96 = loadImg(pathh + "p96.png");
        p97 = loadImg(pathh + "p97.png");
        p98 = loadImg(pathh + "p98.png");
        p99 = loadImg(pathh + "p99.png");
        p100 = loadImg(pathh + "p100.png");
        p101 = loadImg(pathh + "p101.png");
        p102 = loadImg(pathh + "p102.png");
        p103 = loadImg(pathh + "p103.png");
        p104 = loadImg(pathh + "p104.png");
        p105 = loadImg(pathh + "p105.png");
        p106 = loadImg(pathh + "p106.png");
        p107 = loadImg(pathh + "p107.png");
        p108 = loadImg(pathh + "p108.png");
        p109 = loadImg(pathh + "p109.png");
        p110 = loadImg(pathh + "p110.png");
        p111 = loadImg(pathh + "p111.png");
        p112 = loadImg(pathh + "p112.png");
        p113 = loadImg(pathh + "p113.png");
        p114 = loadImg(pathh + "p114.png");
        p115 = loadImg(pathh + "p115.png");
        p116 = loadImg(pathh + "p116.png");
        p117 = loadImg(pathh + "p117.png");
        p118 = loadImg(pathh + "p118.png");
        p119 = loadImg(pathh + "p119.png");
        p120 = loadImg(pathh + "p120.png");
        p121 = loadImg(pathh + "p121.png");
        p122 = loadImg(pathh + "p122.png");
        p123 = loadImg(pathh + "p123.png");
        p124 = loadImg(pathh + "p124.png");
        p125 = loadImg(pathh + "p125.png");
        p126 = loadImg(pathh + "p126.png");
        p127 = loadImg(pathh + "p127.png");
        p128 = loadImg(pathh + "p128.png");
        p129 = loadImg(pathh + "p129.png");
        p130 = loadImg(pathh + "p130.png");
        p131 = loadImg(pathh + "p131.png");
        p132 = loadImg(pathh + "p132.png");
        p133 = loadImg(pathh + "p133.png");
        p134 = loadImg(pathh + "p134.png");
        p135 = loadImg(pathh + "p135.png");
        p136 = loadImg(pathh + "p136.png");
        p137 = loadImg(pathh + "p137.png");
        p138 = loadImg(pathh + "p138.png");
        p139 = loadImg(pathh + "p139.png");
        p140 = loadImg(pathh + "p140.png");
        p141 = loadImg(pathh + "p141.png");
        p142 = loadImg(pathh + "p142.png");
        p143 = loadImg(pathh + "p143.png");
        p144 = loadImg(pathh + "p144.png");
        p145 = loadImg(pathh + "p145.png");
        p146 = loadImg(pathh + "p146.png");
        p147 = loadImg(pathh + "p147.png");
        p148 = loadImg(pathh + "p148.png");
        p149 = loadImg(pathh + "p149.png");
        p150 = loadImg(pathh + "p150.png");
        p151 = loadImg(pathh + "p151.png");
        p152 = loadImg(pathh + "p152.png");
        p153 = loadImg(pathh + "p153.png");
        p154 = loadImg(pathh + "p154.png");
        p155 = loadImg(pathh + "p155.png");
        p156 = loadImg(pathh + "p156.png");
        p157 = loadImg(pathh + "p157.png");
        p158 = loadImg(pathh + "p158.png");
        p159 = loadImg(pathh + "p159.png");
        p160 = loadImg(pathh + "p160.png");
        p161 = loadImg(pathh + "p161.png");
        p162 = loadImg(pathh + "p162.png");
        p163 = loadImg(pathh + "p163.png");
        p164 = loadImg(pathh + "p164.png");
        p165 = loadImg(pathh + "p165.png");
        p166 = loadImg(pathh + "p166.png");
        p167 = loadImg(pathh + "p167.png");
        p168 = loadImg(pathh + "p168.png");
        p169 = loadImg(pathh + "p169.png");
        p170 = loadImg(pathh + "p170.png");
        p171 = loadImg(pathh + "p171.png");
        p172 = loadImg(pathh + "p172.png");
        p173 = loadImg(pathh + "p173.png");
        p174 = loadImg(pathh + "p174.png");
        p175 = loadImg(pathh + "p175.png");
        p176 = loadImg(pathh + "p176.png");
        p177 = loadImg(pathh + "p177.png");
        p178 = loadImg(pathh + "p178.png");
        p179 = loadImg(pathh + "p179.png");
        p180 = loadImg(pathh + "p180.png");
        p181 = loadImg(pathh + "p181.png");
        p182 = loadImg(pathh + "p182.png");
        p183 = loadImg(pathh + "p183.png");
        p184 = loadImg(pathh + "p184.png");
        p185 = loadImg(pathh + "p185.png");
        p186 = loadImg(pathh + "p186.png");
        p187 = loadImg(pathh + "p187.png");
        p188 = loadImg(pathh + "p188.png");
        p189 = loadImg(pathh + "p189.png");
        p190 = loadImg(pathh + "p190.png");
        p191 = loadImg(pathh + "p191.png");
        p192 = loadImg(pathh + "p192.png");
        p193 = loadImg(pathh + "p193.png");
        p194 = loadImg(pathh + "p194.png");
        p195 = loadImg(pathh + "p195.png");
        p196 = loadImg(pathh + "p196.png");
        p197 = loadImg(pathh + "p197.png");
        p198 = loadImg(pathh + "p198.png");
        p199 = loadImg(pathh + "p199.png");
        p200 = loadImg(pathh + "p200.png");
        p201 = p1;
        p202 = p2;
        p203 = p3;
        p204 = p4;
        p205 = p5;
        p206 = p6;
        p207 = p7;
        p208 = p8;
        p209 = p9;
        p210 = p10;
        p211 = p11;
        p212 = p12;
        p213 = p13;
        p214 = p14;
        p215 = p15;
        p216 = p16;
        p217 = p17;
        p218 = p18;
        p219 = p19;
        p220 = p20;
        p221 = p21;
        p222 = p22;
        p223 = p23;
        p224 = p24;
        p225 = p25;
        p226 = p26;
        p227 = p27;
        p228 = p28;
        p229 = p29;
        p230 = p30;
        p231 = p31;
        p232 = p32;
        p233 = p33;
        p234 = p34;
        p235 = p35;
        p236 = p36;
        p237 = p37;
        p238 = p38;
        p239 = p39;
        p240 = p40;
        p241 = p41;
        p242 = p42;
        p243 = p43;
        p244 = p44;
        p245 = p45;
        p246 = p46;
        p247 = p47;
        p248 = p48;
        p249 = p49;
        p250 = p50;
        p251 = p51;
        p252 = p52;
        p253 = p53;
        p254 = p54;
        p255 = p55;
        p256 = p56;
        p257 = p57;
        p258 = p58;
        p259 = p59;
        p260 = p60;
        p261 = p61;
        p262 = p62;
        p263 = p63;
        p264 = p64;
        p265 = p65;
        p266 = p66;
        p267 = p67;
        p268 = p68;
        p269 = p69;
        p270 = p70;
        p271 = p71;
        p272 = p72;
        p273 = p73;
        p274 = p74;
        p275 = p75;
        p276 = p76;
        p277 = p77;
        p278 = p78;
        p279 = p79;
        p280 = p80;
        p281 = p81;
        p282 = p82;
        p283 = p83;
        p284 = p84;
        p285 = p85;
        p286 = p86;
        p287 = p87;
        p288 = p88;
        p289 = p89;
        p290 = p90;
        p291 = p91;
        p292 = p92;
        p293 = p93;
        p294 = p94;
        p295 = p95;
        p296 = p96;
        p297 = p97;
        p298 = p98;
        p299 = p99;
        p300 = p100;
        p301 = p101;
        p302 = p102;
        p303 = p103;
        p304 = p104;
        p305 = p105;
        p306 = p106;
        p307 = p107;
        p308 = p108;
        p309 = p109;
        p310 = p110;
        p311 = p111;
        p312 = p112;
        p313 = p113;
        p314 = p114;
        p315 = p115;
        p316 = p116;
        p317 = p117;
        p318 = p118;
        p319 = p119;
        p320 = p120;
        p321 = p121;
        p322 = p122;
        p323 = p123;
        p324 = p124;
        p325 = p125;
        p326 = p126;
        p327 = p127;
        p328 = p128;
        p329 = p129;
        p330 = p130;
        p331 = p131;
        p332 = p132;
        p333 = p133;
        p334 = p134;
        p335 = p135;
        p336 = p136;
        p337 = p137;
        p338 = p138;
        p339 = p139;
        p340 = p140;
        p341 = p141;
        p342 = p142;
        p343 = p143;
        p344 = p144;
        p345 = p145;
        p346 = p146;
        p347 = p147;
        p348 = p148;
        p349 = p149;
        p350 = p150;
        p351 = p151;
        p352 = p152;
        p353 = p153;
        p354 = p154;
        p355 = p155;
        p356 = p156;
        p357 = p157;
        p358 = p158;
        p359 = p159;
        p360 = p160;
        p361 = p161;
        p362 = p162;
        p363 = p163;
        p364 = p164;
        p365 = p165;
        p366 = p166;
        p367 = p167;
        p368 = p168;
        p369 = p169;
        p370 = p170;
        p371 = p171;
        p372 = p172;
        p373 = p173;
        p374 = p174;
        p375 = p175;
        p376 = p176;
        p377 = p177;
        p378 = p178;
        p379 = p179;
        p380 = p180;
        p381 = p181;
        p382 = p182;
        p383 = p183;
        p384 = p184;
        p385 = p185;
        p386 = p186;
        p387 = p187;
        p388 = p188;
        p389 = p189;
        p390 = p190;
        p391 = p191;
        p392 = p192;
        p393 = p193;
        p394 = p194;
        p395 = p195;
        p396 = p196;
        p397 = p197;
        p398 = p198;
        p399 = p199;
        p400 = p200;

        p401 = loadImg(pathh + "head.png");
        p402 = loadImg(pathh + "tail.png");
        p403 = loadImg(pathh + "neu.png");
        p404 = loadImg(pathh + "start.jpg");
        p405 = loadImg(pathh + "p333.png");
    }

    public ImageIcon loadImg(String imgUrl) {
        ImageIcon icon = new ImageIcon(getClass().getResource(imgUrl));
        // ImageIcon icon = new ImageIcon(imgUrl);
        return icon;
    }

    public ImageIcon getImageByType(int type) {
        ImageIcon img = null;
        switch (type) {
        case 1:
            img = p1;
            break;
        case 2:
            img = p2;
            break;
        case 3:
            img = p3;
            break;
        case 4:
            img = p4;
            break;
        case 5:
            img = p5;
            break;
        case 6:
            img = p6;
            break;
        case 7:
            img = p7;
            break;
        case 8:
            img = p8;
            break;
        case 9:
            img = p9;
            break;
        case 10:
            img = p10;
            break;
        case 11:
            img = p11;
            break;
        case 12:
            img = p12;
            break;
        case 13:
            img = p13;
            break;
        case 14:
            img = p14;
            break;
        case 15:
            img = p15;
            break;
        case 16:
            img = p16;
            break;
        case 17:
            img = p17;
            break;
        case 18:
            img = p18;
            break;
        case 19:
            img = p19;
            break;
        case 20:
            img = p20;
            break;
        case 21:
            img = p21;
            break;
        case 22:
            img = p22;
            break;
        case 23:
            img = p23;
            break;
        case 24:
            img = p24;
            break;
        case 25:
            img = p25;
            break;
        case 26:
            img = p26;
            break;
        case 27:
            img = p27;
            break;
        case 28:
            img = p28;
            break;
        case 29:
            img = p29;
            break;
        case 30:
            img = p30;
            break;
        case 31:
            img = p31;
            break;
        case 32:
            img = p32;
            break;
        case 33:
            img = p33;
            break;
        case 34:
            img = p34;
            break;
        case 35:
            img = p35;
            break;
        case 36:
            img = p36;
            break;
        case 37:
            img = p37;
            break;
        case 38:
            img = p38;
            break;
        case 39:
            img = p39;
            break;
        case 40:
            img = p40;
            break;
        case 41:
            img = p41;
            break;
        case 42:
            img = p42;
            break;
        case 43:
            img = p43;
            break;
        case 44:
            img = p44;
            break;
        case 45:
            img = p45;
            break;
        case 46:
            img = p46;
            break;
        case 47:
            img = p47;
            break;
        case 48:
            img = p48;
            break;
        case 49:
            img = p49;
            break;
        case 50:
            img = p50;
            break;
        case 51:
            img = p51;
            break;
        case 52:
            img = p52;
            break;
        case 53:
            img = p53;
            break;
        case 54:
            img = p54;
            break;
        case 55:
            img = p55;
            break;
        case 56:
            img = p56;
            break;
        case 57:
            img = p57;
            break;
        case 58:
            img = p58;
            break;
        case 59:
            img = p59;
            break;
        case 60:
            img = p60;
            break;
        case 61:
            img = p61;
            break;
        case 62:
            img = p62;
            break;
        case 63:
            img = p63;
            break;
        case 64:
            img = p64;
            break;
        case 65:
            img = p65;
            break;
        case 66:
            img = p66;
            break;
        case 67:
            img = p67;
            break;
        case 68:
            img = p68;
            break;
        case 69:
            img = p69;
            break;
        case 70:
            img = p70;
            break;
        case 71:
            img = p71;
            break;
        case 72:
            img = p72;
            break;
        case 73:
            img = p73;
            break;
        case 74:
            img = p74;
            break;
        case 75:
            img = p75;
            break;
        case 76:
            img = p76;
            break;
        case 77:
            img = p77;
            break;
        case 78:
            img = p78;
            break;
        case 79:
            img = p79;
            break;
        case 80:
            img = p80;
            break;
        case 81:
            img = p81;
            break;
        case 82:
            img = p82;
            break;
        case 83:
            img = p83;
            break;
        case 84:
            img = p84;
            break;
        case 85:
            img = p85;
            break;
        case 86:
            img = p86;
            break;
        case 87:
            img = p87;
            break;
        case 88:
            img = p88;
            break;
        case 89:
            img = p89;
            break;
        case 90:
            img = p90;
            break;
        case 91:
            img = p91;
            break;
        case 92:
            img = p92;
            break;
        case 93:
            img = p93;
            break;
        case 94:
            img = p94;
            break;
        case 95:
            img = p95;
            break;
        case 96:
            img = p96;
            break;
        case 97:
            img = p97;
            break;
        case 98:
            img = p98;
            break;
        case 99:
            img = p99;
            break;
        case 100:
            img = p100;
            break;
        case 101:
            img = p101;
            break;
        case 102:
            img = p102;
            break;
        case 103:
            img = p103;
            break;
        case 104:
            img = p104;
            break;
        case 105:
            img = p105;
            break;
        case 106:
            img = p106;
            break;
        case 107:
            img = p107;
            break;
        case 108:
            img = p108;
            break;
        case 109:
            img = p109;
            break;
        case 110:
            img = p110;
            break;
        case 111:
            img = p111;
            break;
        case 112:
            img = p112;
            break;
        case 113:
            img = p113;
            break;
        case 114:
            img = p114;
            break;
        case 115:
            img = p115;
            break;
        case 116:
            img = p116;
            break;
        case 117:
            img = p117;
            break;
        case 118:
            img = p118;
            break;
        case 119:
            img = p119;
            break;
        case 120:
            img = p120;
            break;
        case 121:
            img = p121;
            break;
        case 122:
            img = p122;
            break;
        case 123:
            img = p123;
            break;
        case 124:
            img = p124;
            break;
        case 125:
            img = p125;
            break;
        case 126:
            img = p126;
            break;
        case 127:
            img = p127;
            break;
        case 128:
            img = p128;
            break;
        case 129:
            img = p129;
            break;
        case 130:
            img = p130;
            break;
        case 131:
            img = p131;
            break;
        case 132:
            img = p132;
            break;
        case 133:
            img = p133;
            break;
        case 134:
            img = p134;
            break;
        case 135:
            img = p135;
            break;
        case 136:
            img = p136;
            break;
        case 137:
            img = p137;
            break;
        case 138:
            img = p138;
            break;
        case 139:
            img = p139;
            break;
        case 140:
            img = p140;
            break;
        case 141:
            img = p141;
            break;
        case 142:
            img = p142;
            break;
        case 143:
            img = p143;
            break;
        case 144:
            img = p144;
            break;
        case 145:
            img = p145;
            break;
        case 146:
            img = p146;
            break;
        case 147:
            img = p147;
            break;
        case 148:
            img = p148;
            break;
        case 149:
            img = p149;
            break;
        case 150:
            img = p150;
            break;
        case 151:
            img = p151;
            break;
        case 152:
            img = p152;
            break;
        case 153:
            img = p153;
            break;
        case 154:
            img = p154;
            break;
        case 155:
            img = p155;
            break;
        case 156:
            img = p156;
            break;
        case 157:
            img = p157;
            break;
        case 158:
            img = p158;
            break;
        case 159:
            img = p159;
            break;
        case 160:
            img = p160;
            break;
        case 161:
            img = p161;
            break;
        case 162:
            img = p162;
            break;
        case 163:
            img = p163;
            break;
        case 164:
            img = p164;
            break;
        case 165:
            img = p165;
            break;
        case 166:
            img = p166;
            break;
        case 167:
            img = p167;
            break;
        case 168:
            img = p168;
            break;
        case 169:
            img = p169;
            break;
        case 170:
            img = p170;
            break;
        case 171:
            img = p171;
            break;
        case 172:
            img = p172;
            break;
        case 173:
            img = p173;
            break;
        case 174:
            img = p174;
            break;
        case 175:
            img = p175;
            break;
        case 176:
            img = p176;
            break;
        case 177:
            img = p177;
            break;
        case 178:
            img = p178;
            break;
        case 179:
            img = p179;
            break;
        case 180:
            img = p180;
            break;
        case 181:
            img = p181;
            break;
        case 182:
            img = p182;
            break;
        case 183:
            img = p183;
            break;
        case 184:
            img = p184;
            break;
        case 185:
            img = p185;
            break;
        case 186:
            img = p186;
            break;
        case 187:
            img = p187;
            break;
        case 188:
            img = p188;
            break;
        case 189:
            img = p189;
            break;
        case 190:
            img = p190;
            break;
        case 191:
            img = p191;
            break;
        case 192:
            img = p192;
            break;
        case 193:
            img = p193;
            break;
        case 194:
            img = p194;
            break;
        case 195:
            img = p195;
            break;
        case 196:
            img = p196;
            break;
        case 197:
            img = p197;
            break;
        case 198:
            img = p198;
            break;
        case 199:
            img = p199;
            break;
        case 200:
            img = p200;
            break;

        case 201:
            img = p201;
            break;
        case 202:
            img = p202;
            break;
        case 203:
            img = p203;
            break;
        case 204:
            img = p204;
            break;
        case 205:
            img = p205;
            break;
        case 206:
            img = p206;
            break;
        case 207:
            img = p207;
            break;
        case 208:
            img = p208;
            break;
        case 209:
            img = p209;
            break;
        case 210:
            img = p210;
            break;
        case 211:
            img = p211;
            break;
        case 212:
            img = p212;
            break;
        case 213:
            img = p213;
            break;
        case 214:
            img = p214;
            break;
        case 215:
            img = p215;
            break;
        case 216:
            img = p216;
            break;
        case 217:
            img = p217;
            break;
        case 218:
            img = p218;
            break;
        case 219:
            img = p219;
            break;
        case 220:
            img = p220;
            break;
        case 221:
            img = p221;
            break;
        case 222:
            img = p222;
            break;
        case 223:
            img = p223;
            break;
        case 224:
            img = p224;
            break;
        case 225:
            img = p225;
            break;
        case 226:
            img = p226;
            break;
        case 227:
            img = p227;
            break;
        case 228:
            img = p228;
            break;
        case 229:
            img = p229;
            break;
        case 230:
            img = p230;
            break;
        case 231:
            img = p231;
            break;
        case 232:
            img = p232;
            break;
        case 233:
            img = p233;
            break;
        case 234:
            img = p234;
            break;
        case 235:
            img = p235;
            break;
        case 236:
            img = p236;
            break;
        case 237:
            img = p237;
            break;
        case 238:
            img = p238;
            break;
        case 239:
            img = p239;
            break;
        case 240:
            img = p240;
            break;
        case 241:
            img = p241;
            break;
        case 242:
            img = p242;
            break;
        case 243:
            img = p243;
            break;
        case 244:
            img = p244;
            break;
        case 245:
            img = p245;
            break;
        case 246:
            img = p246;
            break;
        case 247:
            img = p247;
            break;
        case 248:
            img = p248;
            break;
        case 249:
            img = p249;
            break;
        case 250:
            img = p250;
            break;
        case 251:
            img = p251;
            break;
        case 252:
            img = p252;
            break;
        case 253:
            img = p253;
            break;
        case 254:
            img = p254;
            break;
        case 255:
            img = p255;
            break;
        case 256:
            img = p256;
            break;
        case 257:
            img = p257;
            break;
        case 258:
            img = p258;
            break;
        case 259:
            img = p259;
            break;
        case 260:
            img = p260;
            break;
        case 261:
            img = p261;
            break;
        case 262:
            img = p262;
            break;
        case 263:
            img = p263;
            break;
        case 264:
            img = p264;
            break;
        case 265:
            img = p265;
            break;
        case 266:
            img = p266;
            break;
        case 267:
            img = p267;
            break;
        case 268:
            img = p268;
            break;
        case 269:
            img = p269;
            break;
        case 270:
            img = p270;
            break;
        case 271:
            img = p271;
            break;
        case 272:
            img = p272;
            break;
        case 273:
            img = p273;
            break;
        case 274:
            img = p274;
            break;
        case 275:
            img = p275;
            break;
        case 276:
            img = p276;
            break;
        case 277:
            img = p277;
            break;
        case 278:
            img = p278;
            break;
        case 279:
            img = p279;
            break;
        case 280:
            img = p280;
            break;
        case 281:
            img = p281;
            break;
        case 282:
            img = p282;
            break;
        case 283:
            img = p283;
            break;
        case 284:
            img = p284;
            break;
        case 285:
            img = p285;
            break;
        case 286:
            img = p286;
            break;
        case 287:
            img = p287;
            break;
        case 288:
            img = p288;
            break;
        case 289:
            img = p289;
            break;
        case 290:
            img = p290;
            break;
        case 291:
            img = p291;
            break;
        case 292:
            img = p292;
            break;
        case 293:
            img = p293;
            break;
        case 294:
            img = p294;
            break;
        case 295:
            img = p295;
            break;
        case 296:
            img = p296;
            break;
        case 297:
            img = p297;
            break;
        case 298:
            img = p298;
            break;
        case 299:
            img = p299;
            break;
        case 300:
            img = p300;
            break;
        case 301:
            img = p301;
            break;
        case 302:
            img = p302;
            break;
        case 303:
            img = p303;
            break;
        case 304:
            img = p304;
            break;
        case 305:
            img = p305;
            break;
        case 306:
            img = p306;
            break;
        case 307:
            img = p307;
            break;
        case 308:
            img = p308;
            break;
        case 309:
            img = p309;
            break;
        case 310:
            img = p310;
            break;
        case 311:
            img = p311;
            break;
        case 312:
            img = p312;
            break;
        case 313:
            img = p313;
            break;
        case 314:
            img = p314;
            break;
        case 315:
            img = p315;
            break;
        case 316:
            img = p316;
            break;
        case 317:
            img = p317;
            break;
        case 318:
            img = p318;
            break;
        case 319:
            img = p319;
            break;
        case 320:
            img = p320;
            break;
        case 321:
            img = p321;
            break;
        case 322:
            img = p322;
            break;
        case 323:
            img = p323;
            break;
        case 324:
            img = p324;
            break;
        case 325:
            img = p325;
            break;
        case 326:
            img = p326;
            break;
        case 327:
            img = p327;
            break;
        case 328:
            img = p328;
            break;
        case 329:
            img = p329;
            break;
        case 330:
            img = p330;
            break;
        case 331:
            img = p331;
            break;
        case 332:
            img = p332;
            break;
        case 333:
            img = p333;
            break;
        case 334:
            img = p334;
            break;
        case 335:
            img = p335;
            break;
        case 336:
            img = p336;
            break;
        case 337:
            img = p337;
            break;
        case 338:
            img = p338;
            break;
        case 339:
            img = p339;
            break;
        case 340:
            img = p340;
            break;
        case 341:
            img = p341;
            break;
        case 342:
            img = p342;
            break;
        case 343:
            img = p343;
            break;
        case 344:
            img = p344;
            break;
        case 345:
            img = p345;
            break;
        case 346:
            img = p346;
            break;
        case 347:
            img = p347;
            break;
        case 348:
            img = p348;
            break;
        case 349:
            img = p349;
            break;
        case 350:
            img = p350;
            break;
        case 351:
            img = p351;
            break;
        case 352:
            img = p352;
            break;
        case 353:
            img = p353;
            break;
        case 354:
            img = p354;
            break;
        case 355:
            img = p355;
            break;
        case 356:
            img = p356;
            break;
        case 357:
            img = p357;
            break;
        case 358:
            img = p358;
            break;
        case 359:
            img = p359;
            break;
        case 360:
            img = p360;
            break;
        case 361:
            img = p361;
            break;
        case 362:
            img = p362;
            break;
        case 363:
            img = p363;
            break;
        case 364:
            img = p364;
            break;
        case 365:
            img = p365;
            break;
        case 366:
            img = p366;
            break;
        case 367:
            img = p367;
            break;
        case 368:
            img = p368;
            break;
        case 369:
            img = p369;
            break;
        case 370:
            img = p370;
            break;
        case 371:
            img = p371;
            break;
        case 372:
            img = p372;
            break;
        case 373:
            img = p373;
            break;
        case 374:
            img = p374;
            break;
        case 375:
            img = p375;
            break;
        case 376:
            img = p376;
            break;
        case 377:
            img = p377;
            break;
        case 378:
            img = p378;
            break;
        case 379:
            img = p379;
            break;
        case 380:
            img = p380;
            break;
        case 381:
            img = p381;
            break;
        case 382:
            img = p382;
            break;
        case 383:
            img = p383;
            break;
        case 384:
            img = p384;
            break;
        case 385:
            img = p385;
            break;
        case 386:
            img = p386;
            break;
        case 387:
            img = p387;
            break;
        case 388:
            img = p388;
            break;
        case 389:
            img = p389;
            break;
        case 390:
            img = p390;
            break;
        case 391:
            img = p391;
            break;
        case 392:
            img = p392;
            break;
        case 393:
            img = p393;
            break;
        case 394:
            img = p394;
            break;
        case 395:
            img = p395;
            break;
        case 396:
            img = p396;
            break;
        case 397:
            img = p397;
            break;
        case 398:
            img = p398;
            break;
        case 399:
            img = p399;
            break;
        case 400:
            img = p400;
            break;

        case 401:
            img = p401;
            break;
        case 402:
            img = p402;
            break;
        case 403:
            img = p403;
            break;
        case 404:
            img = p404;
            break;
        case 405:
            img = p405;
            break;
        }
        return img;
    }

}
