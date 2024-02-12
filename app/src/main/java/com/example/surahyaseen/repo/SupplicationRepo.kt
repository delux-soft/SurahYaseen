package com.example.surahyaseen.repo

import com.example.surahyaseen.model.SupplicationInner
import com.example.surahyaseen.model.SupplicationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SupplicationRepo {


    suspend fun getSupplications(): List<SupplicationModel> {
        return withContext(Dispatchers.IO) {
            listOf(
                SupplicationModel(
                    "Ramadan",
                    listOf(
                        SupplicationInner(
                            "Sehri",
                            "وَبِصَوْمِ غَدٍ نَّوَيْتُ مِنْ شَهْرِ رَمَضَانَ.",
                            "اورمیں نے ماہ رمضان کے کل کے روزے کی نیت کی.",
                            "I Intend to keep the fast for the month of Ramadan."
                        ),
                        SupplicationInner(
                            "Aftari",
                            "اَللّٰهُمَّ اِنَّی لَکَ صُمْتُ وَبِکَ اٰمَنْتُ وَعَلَيْکَ تَوَکَّلْتُ وَعَلٰی رِزْقِکَ اَفْطَرْتُ.",
                            "اے اللہ!میں نے تیری خاطر روزہ رکھا اور تیرے اوپر ایمان لایا اور تجھ پر بھروسہ کیا اورتیرے رزق سے اسے کھول رہا ہوں۔",
                            "O Allah! I fasted for You, and I believe in You, and I put my trust in You, and I break my fast with your sustenance."
                        ),
                        SupplicationInner(
                            "First Ashra",
                            "رَّبِّ اغۡفِرۡ وَارۡحَمۡ وَاَنۡتَ خَيۡرُ الرّٰحِمِيۡنَ",
                            "میرے پروردگار مجھے بخش دے اور (مجھ پر) رحم کر اور تو سب سے بہتر رحم کرنے والا ہے.",
                            "My Lord! Forgive and have mercy, for You are the Best of those who show mercy"
                        ),
                        SupplicationInner(
                            "Second Ashra",
                            "اَسْتَغْفِرُاللهَ رَبِّي مِنْ كُلِّ ذَنْبٍ وَأتُوبُ إلَيهِ",
                            "میرے رب! میں اپنے گناہوں کی مغفرت چاہتا ہوں اور تیری جانب پلٹتا (توبہ کرتا) ہوں۔",
                            "I ask forgiveness of my sins from Allah who is my Lord and I turn towards Him."
                        ),
                        SupplicationInner(
                            "Third Ashra",
                            "اَللَّهُمَّ أَجِرْنِي مِنَ النَّارِ",
                            "اے ﷲ ! مجھے دوزخ کے عذاب سے بچالے",
                            "Oh Allah! Save me from the hell fire"
                        ),
                    )
                ),
                SupplicationModel(
                    "Eat & Drink",
                    listOf(
                        SupplicationInner(
                            "Drinking Milk",
                            "اَللّٰھُمَّ بَارِکْ لَنَافِیْہِ وَزِدْنَامِنْہُ۔",
                            "اے اللہ !اس میں ہمارے لئے برکت عطا فرما اوراس سے زیادہ عطا فرما۔",
                            "O Allah Azzawajal give us abundance in this and grant us more than this."
                        ),
                        SupplicationInner(
                            "Drinking Zam Zam",
                            "اللَّهُمَّ إِنِّي أَسْأَلُكَ عِلْمَاً نَافِعَاًً وَرِزْقَاً وَاسِعَاًَ وَشِفَاءً مِنْ كُلِّ دَاءٍ",
                            "الٰہی عزوجل میں تجھ سے علم نافع کا اور رزق کی کشادگی کا اور بیماری سے شفایابی کا سوال کرتا ہوں۔",
                            "Allah Azzawajal, I ask you for beneficial knowledge, increase in provision and cure from illness."
                        ),

                        )
                ),
                SupplicationModel("Forgiveness", listOf()),
                SupplicationModel("Namaz", listOf()),
                SupplicationModel(
                    "Daily Routine",
                    listOf(
                        SupplicationInner(
                            "Leaving the House",
                            "بِسْمِ اللّٰہِ تَوَکَّلْتُ عَلَی اللّٰہِ لَاحَوْلَ وَلَاقُوَّةَ اِلَّابِاللّٰہِ۔",
                            "اللہ تعالیٰ کے نام کے ساتھ گھر سے نکلتا ہوں،اللہ تعالیٰ پر میں نے بھروسہ کیا ،گناہوں سے بچنے اور عبادت کرنے کی توفیق اللہ تعالیٰ ہی دیتے ہیں۔",
                            "I depart with Allah's name, relying on Him. It is Allah who saves us from sins with His guidance (the ability to do so)"
                        ),
                        SupplicationInner(
                            "Entering the House",
                            "اَللّٰھُمَّ اِنِّیْ اَسْئَلُکَ خَیْرَالْمَوْلِجِ وَخَیْرَالْمَخْرَجِ بِسْمِ اللّٰہِ وَلَجْنَا وَبِسْمِ اللّٰہِ خَرَجْنَا وَعَلَی اللّٰہِ رَبِّنَا تَوَکَّلْنَا ۔",
                            "اے اللہ !میں سؤال کرتا ہوں آپ سے اچھے داخلہ کا اور اچھی طرح نکلنے کا ،اللہ کے نام سے میں داخل ہوا ،اللہ کے نام سے میں نکلااور اپنے رب اللہ پر میں نے بھروسہ کیا ۔",
                            "O Allah, I seek a good entry and a good exit. We take Allah's name to enter and to exit and rely on Him who is our Lord."
                        ),
                        SupplicationInner(
                            "Meeting",
                            "السَّلَامُ عَلَيْكُمُ - وَعَلَيْكُمُ السَّلَامُ",
                            "تم پر سلامتی ہو۔ اور تم پر بھی سلامتی ہو۔ُ",
                            "Peace be upon you and peace be upon you too."
                        ),
                        SupplicationInner(
                            "At the time of rain",
                            "اللَّهُمَّ صَيِّبَاً نَافِعَاً",
                            "اے اللہ اسے نفع دینے والی بارش بنا دے",
                            "O Allah Make It Plentiful and Beneficial"
                        ),
                        SupplicationInner(
                            "New Year",
                            "اللَّهُمَّ أَدْخِلْهُ عَلَيْنَا بِالأَمْنِ ، وَالإِيمَانِ ، وَالسَّلامَةِ ، وَالإِسْلامِ ، وَرِضْوَانٍ مِنَ الرَّحْمَنِ ، وَجَوَازٍ مِنَ الشَّيْطَانِ",
                            "ا الله اس (نئے سال یا نئے مہینے کو ) کو ہم پر امن اور ایمان کے ساتھ اور سلامتی اور اسلام کے ساتھ اور رحمان کی خوشنودی کے ساتھ اور شیطان سے حفاظت کے ساتھ داخل فرما",
                            "O Allah, bring this (month or year) upon us with security and Iman, And with safety and Islam, and with the pleasure of Rahman and Protection from shaitan"
                        ),
                        SupplicationInner(
                            "Sleeping",
                            "اَللّٰهُمَّ بِاسْمِكَ اَمُوْتُ وَ اَحْیٰی.ِ",
                            "اے اللہ! میں تیرا نام لے کر مرتا ہوں اور جیتا ہوں",
                            "O Allah! I die and live in your name."
                        ),
                        SupplicationInner(
                            "Returning the debt",
                            "اَللّٰهُمَّ اكْفِنِيْ بِحَلَالِكَ عَنْ حَرَامِكَ وَأَغْنِنِيْ بِفَضْلِكَ عَنْ مّنْ سِوَاكَِ",
                            "اے اللہ! حرام سے بچاتے ہوئے اپنے حلال کے ذریعہ تو میری کفایت فرما، اور اپنے فضل کے ذریعہ تو مجھے دوسروں سے بے نیاز کردے۔",
                            "O Allah! Save me from the forbidden by means of your halal and make me free from others by means of your grace"
                        ),
                        SupplicationInner(
                            "Relief from debt",
                            "َاَللّٰهُمَّ إِنِّيْ أَعُوْذُ بِكَ مِنَ الْهَمِّ وَالْحُزْنِ وَأَعُوْذُ بِكَ مِنَ الْعَجْزِ وَالْكَسَلِ وَأَعُوْذُ بِكَ مِنَ الْجُبْنِ وَالْبُخْلِ وَأَعُوْذُ بِكَ مِنْ غَلَبَةِ الدَّيْنِ وَقَهْرِ الرِّجَالِ",
                            "اے اللہ! میں تیری پناہ چاہتا ہوں فکر اور غم سے اور نکمے پن اور ٹھول پنے سے، اور سستی و کاہلی سے، اور بزدلی اور کنجوسی سے، اور پناہ مانگتا ہوں قرضے کے بار کے غالب آجانے سے اور لوگوں کے دباؤ سے۔",
                            "O Allah! I am seeking refuge from thoughts of grief, from fear, from weakness and laziness, from cowardice and miserliness, from the burden of debt and from the pressure of people."
                        ),
                        SupplicationInner(
                            "Relief from poverty",
                            "َيَاأَوَّلَ الْأَوَّلِيْنَ يَا اٰخِرَ الْاٰخِرِيْنَ ذَا الْقُوَّةِ الْمَتِيْنِ وَيَا رَاحِمَ الْمَسَاكِيْنِ وَيَا أَرْحَمَ الرَّاحِمِيْنَِ",
                            "اے سب سے اول! اے سب سے آخر! قوت وطاقت والے! اے مساکین پہ رحم کرنے والے! اے سب سے زیادہ رحم کرنے والے!",
                            "O first! O last! Strong and powerful! O those who have mercy on the poor! O most merciful!"
                        ),
                        SupplicationInner(
                            "Alhamdulillah for sneezing",
                            "يَرْحَمُكَ اللَّهَُِ",
                            "اللہ عزوجل تجھ پر رحم کرے۔",
                            "May Allah have mercy upon you"
                        ),
                        SupplicationInner(
                            "Seeing the new moon",
                            "اَللّٰهُمَّ أَهِلَّهٗ عَلَيْنَا بِالْیُمْنِ وَالْإِيمَانِ وَالسَّلَامَةِ وَالْإِسْلَامِ وَالتَّوْفِیْقِ لِمَا تُحِبُّ وَ تَرْضٰی، رَبِّيْ وَرَبُّكَ اللّٰهَُُِ",
                            "اے اللہ! اسے تو ہمارے اوپر برکت اور ایمان اور سلامت اور اسلام کے ساتھ اورا ن اعمال کی توفیق کے ساتھ نکلا ہوا رکھ جو تجھے پسند ہیں اور جن سے تو راضی ہے، اے چاند! میرا اور تیرا رب اللہ ہے۔",
                            "O Allah! May you bless us with faith, health, and Islam, and keep those who are pleased with you, O Chand! Mira and Tira is the Lord of God."
                        ),
                        SupplicationInner(
                            "Sunrise",
                            "اَلْحَمْدُ لِلّٰهِ الَّذِيْ أَقَالَنَا يَوْمَنَا هٰذَا وَ لَمْ يُهْلِكْنَا بِذُنُوْبِنَا.َُُِ",
                            "سب تعریفیں اللہ ہی کے لیے ہیں، جس نے آج ہمیں معاف رکھا، اور گناہوں کے سبب ہمیں ہلاک نہ فرمایا۔",
                            "All praises are for Allah, who has spared us today and did not destroy us because of our sins."
                        ),
                        SupplicationInner(
                            "Entering the Marketplace",
                            "لَا اِلٰهَ اِلَّا اللّٰهُ وَحْدَهٗ لَاشَرِیْك لَهٗ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ، یُحْيِیْ وَ یُمِیْتُ، وَھُوَ حَيٌّ لَّا یَمُوْتُ، بِیَدِهِ الْخَیْرُ، وَھُوَ عَلٰی كُلِّ شَیْئٍ قَدِیْرٌ۔َُُِ",
                            "اللہ کے سوا کوئی معبود نہیں، وہ تنہا ہے، اس کا کوئی شریک نہیں، اسی کے لئے ملک ہے، اور اسی کے لئے حمد ہے، وہی زندہ کرتا ہے اور مارتا ہے، اور وہ خود زندہ ہے اسے موت نہ آئے گی، اس کے ہاتھ میں بھلائی ہے اور وہ ہر چیز پر قادر ہے۔",
                            "There is no god but Allah, He is alone, He has no partner, He belongs to Him, He belongs to Him, He is praised, He is alive, He is alive, He is alive, and death does not come to him. He is capable of everything."
                        ),
                        SupplicationInner(
                            "Perseverance and mercy",
                            "رَبَّنَا لَا تُزِغْ قُلُوْبَنَا بَعْدَ إِذْ هَدَيْتَنَا وَهَبْ لَنَا مِنْ لَّدُنْكَ رَحْمَةً إِنَّكَ أَنْتَ الْوَهَّابُ۔ رَبَّنَا إِنَّكَ جَامِعُ النَّاسِ لِيَوْمٍ لَّا رَيْبَ فِيهِ إِنَّ اللَّهَ لَا يُخْلِفُ الْمِيْعَادََُُِ",
                            "اے ہمارے پروردگار! ہمارے دلوں کو ہدایت کرنے کے بعد (غلط راستے پر) نہ پھیر، اور اپنے پاس سے ہم کو رحمت عطا فرما، بےشک تو ہی دینے والا ہے۔ اے ہمارے پروردگار! تو ایک دن جس (کے آنے) میں (کسی طرح کا) شبہ ہی نہیں لوگوں کو (اعمال کی جزاوسزا کے لیے) اکٹھا کرے گا (تو اس دن ہم پر تیری مہربانی کی نظر رہے)، بےشک اللّٰہ تعالیٰ وعدہ خلافی نہیں کیا کرتا۔",
                            "O our Lord! After guiding our hearts, do not go astray, and grant us mercy from Your presence, indeed You are the One who bestows. O our Lord! In one day, I do not suspect that people will be gathered together (for actions that are punishable)۔"
                        ),
                        SupplicationInner(
                            "Gratitude for blessings",
                            "اَللّٰهُمَّ\u200Cاجْعَلْنِيْ \u200Cأُعَظِّمُ شُكْرَكَ وَأُكْثِرُ ذِكْرَكَ وَأَتَّبِعُ نَصِيْحَتَكَ وَأَحْفَظُ وَصِيَّتَكَََُُِ",
                            "اے اللہ! مجھے ایساکردے کہ میں تیری نعمتوں کے شکر کی عظمت و اہمیت کو سمجھوں ( تا کہ پھر شکر میں کوتاہی نہ کروں) اور تیرا ذکر کثرت سے کروں اور تیری نصیحتوں کی پیروی کروں اور تیری وصیتوں اور حکموں کو یاد رکھوں (اور ان کی تعمیل سے غفلت نہ برتوں)۔",
                            "O Allah! You made me so that I should understand the greatness and importance of gratitude for your favors (so that I would not be short in my gratitude), and I should remember you in abundance, and you should follow your advice, and you should remember your wills and decrees (and that by obeying Don't neglect them)."
                        ),
                        SupplicationInner(
                            "After Sneezing",
                            "الحمد للہ  الحمدُللہَََُُِ",
                            "تمام تعریفیں اللہ کے لیے ہیں۔",
                            "All praise is for Allah."
                        ),
                        SupplicationInner(
                            "Travel Prayer",
                            "سُبْحَانَ الَّذِي سَخَّرَ لَنَا هَذَا وَمَا كُنَّا لَهُ مُقْرِنِينَ وَإِنَّا إِلَى رَبِّنَا لَمُنْقَلِبُونََََُُِ",
                            "اللہ عزوجل کا شکر ہے، پاک ہے وہ جس نے ہمارے لئے اس(سواری کو) مسخر کیا اور ہم اس کو فرمانبردار نہیں بنا سکتے تھے۔",
                            "Praise be to Allah, Exalted is He who subjected it (the rider) to us and we could not make it obedient."
                        ),
                        SupplicationInner(
                            "Morning & Evening",
                            "رَضِيْتُ بِاللّٰهِ رَبًّا وَّ بِالْإِسْلَامِ دِيْنًا وَّ بِمُحَمَّدٍ نَّبِيًّا (صَلَّى اللهُ عَلَيْهِ وَ سَلَّمَ).ََََُُِ",
                            "میں اللہ کو رب ماننے پر اور اسلام کو دین ماننے پر اور محمد صلی اللہ علیہ و سلم کو نبی ماننے پر راضی ہوں۔",
                            "I am pleased with Allah, the Lord, and with Islam, the religion, and with Muhammad, the Prophet (peace and blessings of Allah be upon him). I am satisfied that Allah is the Lord, and Islam is the religion, and Muhammad is the prophet."
                        ),
                        SupplicationInner(
                            "Morning",
                            "اَصْبَحْنَا وَاَصْبَحَ الْمُلْکُ لِلّٰہِ رَبِّ الْعَالَمِیْنَ اَللّٰھُمَّ اِنِّیْ اَسْاَلُکَ خَیْرَ ھٰذَاالْیَومِ وَفَتْحَہ وَنَصْرَہ وَنُوْرَہ وَبَرَ کَتَہ وَھُدَاہُ وَاَعُوْذُبِکَ مِنْ شَرِّ مَافِیْہِ وَشَرِّ مَابَعْدَہ۔",
                            "ہم نے اللہ کے ملک میں صبح کی جوتمام جہانوں کا رب ہے، اے اللہ! میں آپ سے سؤال کرتا ہوں اس دن کی بھلائی کا ، فتح ونصرت،نوروبرکت اور ہدایت کا ،اور اس دن کے بعد کی برائیوں سے پناہ مانگتا ہوں۔",
                            "We have entered a new day and with it all the dominion which belongs to Allah, Lord of all that exists. O Allah, I ask You for the goodness of this day, its victory, its help, its light, its blessings, and its guidance. I seek refuge in You from the evil that is in it and from the evil that follows it."
                        ),
                        SupplicationInner(
                            "Evening",
                            "اَمْسَیْنَاوَاَمْسَی الْمُلْکُ لِلّٰہِ رَبِّ الْعَالَمِیْنَ اَللّٰہُمَّ اِنِّیْ اَسْئَلُکَ خَیْرَ ھَذِہِ اللَّیْلَةِ وَفَتْحَھَاوَنَصْرَھَا وَنُوْرَھَا وَبَرَکَتَہَا وَھُدَاھَاوَاَعُوْذُ بِکَ مِنْ شَرِّ مَافِیْھَا وَشَرِّ مَابَعْدَھَا۔",
                            "ہم نے اللہ کے ملک میں شام کی ،اے اللہ !میں آپ سے اس رات کی بھلائی کا ،فتح و نصرت ،نوروبرکت اور ہدایت کا سؤال کرتا ہوں ،اور اس رات کی برائی اور اس کے بعد کی برائیوں سے پناہ مانگتا ہوں ۔",
                            "The evening has come to me and the whole universe belongs to Allah who is The Lord of the worlds. O Allah, I ask of you the good of the night, it's success and aid and its Nur (celestial light) and Barakat (blessings) and seek hid Ayat (guidance) and refuge from the evil of this night and the evil that is to come later."
                        ),
                        SupplicationInner(
                            "After Azaan",
                            "اَللّٰہُمَّ رَبَّ ھٰذِہِ الدَّعْوَةِ التَّآمَّةِ وَالصَّلٰوةِ الْقَآئِمَةِ اٰتِ مُحَمَّدَنِ الْوَسِیْلَةَ وَالْفَضِیْلَةَ وَابْعَثْہُ مَقَامًا مَّحْمُوْدَنِ الَّذِیْ وَعَدْتَّہ ۔",
                            "یااللہ !اس کامل اعلان اور قائم ہونے والی نماز کے مالک، محمدۖکو مقامِ وسیلہ عطا فرما اور ان کی فضیلت میں اضافہ فرما اور ان کو مقامِ محمود پر پہنچا جس کا تو نے ان سے وعدہ کیا ہے ۔",
                            "O Allah, Lord of this perfect call and established prayer. Grant Muhammad the intercession and favor and raise him to the honored station You have promised him, [verily You do not neglect promises]."
                        ),
                        SupplicationInner(
                            "In time of trouble",
                            "اِنَّالِلّٰہِ وَاِنَّااِلَیْہِ رَاجِعُوْنَ،اَللّٰھُمَّ أْجُرْنِیْ فِیْ مُصِیْبَتِیْ وَاَخْلِفْ لِیْ خَیْرًامِّنْھَا",
                            "ہم تو اللہ ہی کے ہیں اور اس کی طرف لوٹ کر جانے والے ہیں ، اے اللہ !مجھے اپنی مصیبت میں اجر دے اوراس کا نعم البدل عطا فرما۔",
                            "Definitely we are from Allah and to Him is our return. O Allah, grant reward in my calamity and grant in its place a good substitute."
                        ),
                        SupplicationInner(
                            "Entering in washroom",
                            "اَللّٰہُمَّ اِنِّیْ اَعُوْذُبِکَ مِنَ الْخُبُثِ وَالْخَبَآئِثِ۔",
                            "اے اللہ !میں آپ کی پناہ پکڑتا ہوں تمام شیاطین (مردوں اورعورتوں) کے شرسے۔",
                            "O Allah (Almighty) I seek your refuge from impure Jinnat (male and female)."
                        ),
                        SupplicationInner(
                            "Exit from washroom",
                            "اَلْحَمْدُ لِلّٰہِ الَّذِیْ اَذْھَبَ عَنِّی الْاَذٰی وَعَافَانِیْْ ",
                            "شکر ہے اس اللہ کا جس نے مجھ سے گندگی دور کردی اور مجھ کوعافیت دی۔",
                            "شکر ہے اس اللہ کا جس نے مجھ سے گندگی دور کردی اور مجھ کوعافیت دی۔"
                        ),
                        SupplicationInner(
                            "Start of wozo",
                            "بِسْمِ اللّٰہِ الرَّحْمٰنِ الرَّحِیْمِ۔",
                            "شروع کرتا ہوں اللہ کے نام سے جو بڑا مہربان، نہایت رحم والا ہے ۔",
                            "In the name of Allah, the most merciful, the most kind"
                        ),
                        SupplicationInner(
                            "Protection from diseases",
                            "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْبَرَصِ، وَالْجُنُونِ، وَالْجُذَامِ، وَمِنْ سَيِّئِ الأَسْقَامِ",
                            "اے اللہ میں کوڑھ، جنون، ہاتھی کی بیماری اور بری بیماریوں سے تیری پناہ مانگتا ہوں",
                            "Allah, I seek refuge in You from leprosy, madness, elephantiasis, and evil diseases"
                        ),
                        SupplicationInner(
                            "Time of storm",
                            "اَللّٰہُمَّ اِنِّیْ اَسْئَلُکَ خَیْرَھَا وَخَیْرَمَافِیْھَاوَخَیْرَ مَااُرْسِلَتْ بِہ وَاَعُوْذُبِکَ مِنْ شَرِّھَا وَشَرِّ مَافِیْھَاوَشَرِّ مَااُرْسِلَتْ بِہ۔ِ",
                            "اے اللہ !میں آپ سے اس کی خیر اور جو اس میں ہے اور جس کے ساتھ بھیجی گئی ہے بہتری کا سؤال کرتا ہوں اور اس کی برائی اور جوکچھ اس میں ہے اور جس کے ساتھ بھیجی گئی ہے سے پناہ مانگتا ہوں۔",
                            "O Allah, I ask you for its goodness, the good within it, and the good it was sent with, and I take refuge with you from its evil, the evil within it, and from the evil it was sent with."
                        ),
                        SupplicationInner(
                            "Increase Knowledge",
                            "رَّبِّ زِدْنِي عِلْمًاِ",
                            "اے میرے رب میرے علم میں اضافہ فرما۔ ",
                            "O My Lord, Increase my knowledge."
                        ),
                        SupplicationInner(
                            "For parents",
                            "رَّبِّ ارْحَمْهُمَا كَمَا رَبَّيَانِي صَغِيرًاِ",
                            "اے میرے رب ان (والدین) پر رحم فرما جیسا کہ انہوں نے مجھے بچپن میں پالا تھا",
                            "My Lord, have mercy upon them (parents) as they brought me up [when I was] small."
                        ),
                        SupplicationInner(
                            "Of Life & Death",
                            "اللَّهُمَّ أَحْيِنِي مَا كَانَتِ الْحَيَاةُ خَيْرٌ لِي وَتَوَفَّنِي إِذَا كَانَتِ الْوَفَاةُ خَيْرَاً لِيِ",
                            "اے اللہ! جب تک میرے لیے زندگی بہتر ہے مجھے زندہ رکھیو اور جب میرے لیے موت بہتر ہو تو مجھے اٹھا لیجیو۔",
                            "O Allah! Take me as long as life is better for me and when death is better for me."
                        ),
                        SupplicationInner(
                            "Heale the patient",
                            "اَسْأَلُ اللّٰہَ الْعَظِیْمَ رَبَّ الْعَرْشِ الْعَظِیْمِ اَنْ یَّشْفِیَکَِ",
                            "عرش عظیم کے بلند وبالا خدا سے آپ کی صحت کا سؤال کرتا ہوں۔(سات مرتبہ)",
                            "I ask Allah who is the Lofty and the Lord of the Mighty Throne that He cures you"
                        ),
                        SupplicationInner(
                            "Pain & fever",
                            "بِسْمِ اللَّهِ الْكَبِيرِ أَعُوذُ بِاللَّهِ الْعَظِيمِ مِنْ شَرِّ كُلِّ عَرَقٍ نَعَّارٍ وَمِنْ شَرِّ حَرِّ النَّارَِِ",
                            "شروع اللہ کے نام سے جو کبریائی والا ہے اور میں اس اللہ کی پناہ میں آتا ہوں جو عظمت والا ہے پھڑکتی رگ اور آگ کی گرمی سے",
                            "I seek relief taking Allah's great blessed name from all the evils of pulling (pulsating) nerves and from the evils of the hot fire."
                        ),
                        SupplicationInner(
                            "Entering the cemetery",
                            "السَّلَامُ عَلَيْكُمُ يَا أَهْلَ الْقُبُورِ يَغْفِرُ اللَّهُ لَنَا وَلَكُمْ أَنْتُمُ سَلَفُنَا وَنَحْنُ بِالْأَثَرَِِِ",
                            "اے قبر والوں تم پر سلام ہو۔ اللہ عزوجل ہماری اور تمہاری مغفرت فرما۔ اور تم ہم سے پہلے پہنچ گئے اور ہم پیچھے آنےوالے ہیں۔",
                            "O dwellers of the grave’s peace be upon you. May Allah Azzawajal forgive us and you. You reached before us and we will follow behind you"
                        ),
                        SupplicationInner(
                            "Protection from Sheitan",
                            "بِسْمِ اللهِ اللَّهُمَّ جَنِّبْنَا الشَّيْطَانَ ، وَجَنِّبِ الشَّيْطَانَ مَا رَزَقْـتَنَا ",
                            "اللہ کے نام پر۔ اے اللہ شیطان کو ہم سے دور رکھ اور شیطان کو اس سے دور رکھ جو تو نے ہمیں عطا کی ہے۔",
                            "In the Name of Allah. O Allah, keep the Sheitan away from us and keep the Sheitan away from what You have blessed us with. "
                        ),
                        SupplicationInner(
                            "After the Nikkah",
                            "بَارَکَ اللّٰہُ لَکَ وَبَارَکَ عَلَیْکَ وَجَمَعَ بَیْنَکُمَا فِیْ خَیْرٍ۔",
                            "اللہ تعالیٰ آ پ دونوں (زوجین)پر برکتیں نازل فرمائیں اور دونوں کو حسن معاشرت عطافرمائیں۔",
                            "Allah Azzwajal bless you and shower (send) blessing on you and place, goodness between both of you."
                        ),SupplicationInner(
                            "Wearing clothes",
                            "اَلْحَمْدُ لِلّٰہِ الَّذِیْ کَسَانِیْ ھٰذَا وَرَزَقَنِیْہِ مِنْ غَیْرِ حَوْلٍ مِّنِّیْ وَلَاقُوَّةٍ۔",
                            "تمام تعریفیں اس ذات گرامی کی جس نے ہمیں یہ پہنایا اوربغیر میری قوت وطاقت کے مجھے نوازا۔",
                            "All Praise is for Allah who has clothed me with this garment and provided it for me, with no power nor might from myself."
                        ),SupplicationInner(
                            "For the hereafter and blessing",
                            "رَبَّنَآ ءَاتِنَا فِي ٱلدُّنيَا حَسَنَةٗ وَفِي ٱلأٓخِرَةِ حَسَنَةٗ وَقِنَا عَذَابَ ٱلنَّارِ",
                            "اے ہمارے رب! ہمیں دنیا میں بھی بھلائی دے اور آخرت میں بھی بھلائی اور آگ کے عذاب سے ہمیں بچا۔",
                            "Our Lord! Grant us good in this world and good in the hereafter, and save us from the chastisement of the fire "
                        ),

                        )
                ),
            )
        }
    }
}