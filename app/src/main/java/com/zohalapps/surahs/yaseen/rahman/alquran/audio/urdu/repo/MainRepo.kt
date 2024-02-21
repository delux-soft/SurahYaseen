package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.repo

import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.raw
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.NamesModel
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.QalmaModel
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.QulModel
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.SurahModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object MainRepo {


    suspend fun getSurahYaseen(): List<SurahModel> {
        return withContext(Dispatchers.IO) {
            listOf(
                SurahModel("file:///android_asset/yaseen/syl.png", raw.syls),
                SurahModel("file:///android_asset/yaseen/syk.png", raw.syks),
                SurahModel("file:///android_asset/yaseen/syj.png", raw.syjs),
                SurahModel("file:///android_asset/yaseen/syi.png", raw.syis),
                SurahModel("file:///android_asset/yaseen/syh.png", raw.syhs),
                SurahModel("file:///android_asset/yaseen/syg.png", raw.sygs),
                SurahModel("file:///android_asset/yaseen/syf.png", raw.syfs),
                SurahModel("file:///android_asset/yaseen/sye.png", raw.syes),
                SurahModel("file:///android_asset/yaseen/syd.png", raw.syds),
                SurahModel("file:///android_asset/yaseen/syc.png", raw.sycs),
                SurahModel("file:///android_asset/yaseen/syb.png", raw.sybs),
                SurahModel("file:///android_asset/yaseen/sya.png", raw.syas)
            )
        }
    }


    suspend fun getSurahRehman(): List<SurahModel> {
        return withContext(Dispatchers.IO) {
            listOf(
                SurahModel("file:///android_asset/rehman/srk.png", raw.syks),
                SurahModel("file:///android_asset/rehman/srj.png", raw.syjs),
                SurahModel("file:///android_asset/rehman/sri.png", raw.syis),
                SurahModel("file:///android_asset/rehman/srh.png", raw.syhs),
                SurahModel("file:///android_asset/rehman/srg.png", raw.sygs),
                SurahModel("file:///android_asset/rehman/srf.png", raw.syfs),
                SurahModel("file:///android_asset/rehman/sre.png", raw.syes),
                SurahModel("file:///android_asset/rehman/srd.png", raw.syds),
                SurahModel("file:///android_asset/rehman/src.png", raw.sycs),
                SurahModel("file:///android_asset/rehman/srb.png", raw.sybs),
                SurahModel("file:///android_asset/rehman/sra.png", raw.syas)
            )
        }
    }

    suspend fun getAllahAttributes(): MutableList<NamesModel> {
        return withContext(Dispatchers.IO) {
            mutableListOf(
                NamesModel(
                    "AR-RAHMAAN",
                    "ٱلْرَّحْمَـانُ",
                    "The Most Beneficent",
                    "بے پایاں رحم کرنے والا",
                    "Reciting it 100 times after every obligatory prayer will enhance memory and awareness. The reciter will feel the burden vanishing away from his heart",
                    "He who wills goodness and mercy for all His creatures"
                ),
                NamesModel(
                    "AR-RAHEEM",
                    "ٱلْرَّحِيْمُ",
                    "The Most Merciful",
                    "بڑا رحم کرنے والا",
                    "Reciting it after Fajr prayer 100 times will keep the person safe from all tribulation. Moreover, he will find everyone benevolent towards him.",
                    "He who acts with extreme kindness"
                ),
                NamesModel(
                    "AL-MALIK",
                    "ٱلْمَلِكُ",
                    "The King, The Sovereign Lord",
                    "حاکم کائنات",
                    "Recitation of this name after Fajr prayer will make a person become rich.",
                    "The Sovereign Lord, The One with the complete Dominion, the One Whose Dominion is clear from imperfection"
                ),
                NamesModel(
                    "AL-QUDDUS",
                    "ٱلْقُدُّوسُ",
                    "The Holy",
                    "پاک",
                    "Agitation never comes close if someone recites it 100 times every day.",
                    "The One who is pure from any imperfection and clear from children and adversaries"
                ),
                NamesModel(
                    "AS-SALAM",
                    "ٱلْسَّلَامُ",
                    "The source of peace",
                    "امن و سلامتی کا سر چشمہ",
                    "The sick will regain his health if this is recited to him 160 times. It also keeps the frequent reciter, of this name, safe from all types of tribulations.",
                    "The One who is free from every imperfection"
                ),
                NamesModel(
                    "AL-MU’MIN",
                    "ٱلْمُؤْمِنُ",
                    "The guardian of faith",
                    "آفات و وعذاب سے امن و امان رکھنے والا",
                    "Reciting it 631 times will keep you safe from anguish.",
                    "The One who witnessed for Himself that no one is God but Him. And He witnessed for His believers that they are truthful in their belief that no one is God but Him"
                ),
                NamesModel(
                    "AL-MUHAYMIN",
                    "ٱلْمُهَيْمِنُ",
                    "The protector",
                    "حفاظت کرنے والا",
                    "This purifies the soul of a person if it is recited 100 times after taking a bath and offering two rakaats of prayer.",
                    "The One who witnesses the saying and deeds of His creatures"
                ),
                NamesModel(
                    "AL-AZIZ",
                    "ٱلْعَزِيزُ",
                    "The Almighty",
                    "بڑے اقتدار والا",
                    "Recitation of this name 41 times after Fajr prayer will make the person independent from others and will earn respect.",
                    "The Strong, The Defeater who is not defeated"
                ),
                NamesModel(
                    "AL-JABBAR",
                    "ٱلْجَبَّارُ",
                    "The compeller",
                    "زبردست غلبہ رکھنے والا",
                    "Whoever recites this name several times will not be forced to do anything. He will be safe from cruelty and hardship.",
                    "The One that nothing happens in His Dominion except that which He willed"
                ),
                NamesModel(
                    "AL-MUTAKABBIR",
                    "ٱلْمُتَكَبِّرُ",
                    "The Majestic",
                    "عظمت و کبریائی کا سر چشمہ",
                    "The one who recites this name frequently will earn respect and gain success.",
                    "The One who is clear from the attributes of the creatures and from resembling them."
                ),
                NamesModel(
                    "AL-KHAALIQ",
                    "ٱلْخَالِقُ",
                    "The Creator",
                    "وجود بخشنے والا، پیدا کرنے والا",
                    "Allah will assign an angel to guide the person righteously if he recites this name 100 times continuously for a prescribed limit of 7 days.",
                    "The One who brings everything from non-existence to existence"
                ),
                NamesModel(
                    "AL-BAARI",
                    "ٱلْبَارِئُ",
                    "The Evolver, The Maker",
                    "ہر چیز کو عدم سے وجود میں لانے والا",
                    "This name only signifies that Allah created all things in proportion.",
                    "The Maker, The Creator who has the Power to turn the entities."
                ),
                NamesModel(
                    "AL-MUSAWWIR",
                    "ٱلْمُصَوِّرُ",
                    "The Fashioner of Forms",
                    "مخلوقات کی صورت گری کرنے والا",
                    "Recite this name 21 times and do a Damm on water. Continue this for 7 consecutive days. Use the water for breaking the fast. Insha’Allah, the woman will soon be blessed with a child.",
                    "The One who forms His creatures in different pictures."
                ),
                NamesModel(
                    "AL-GHAFFAAR",
                    "ٱلْغَفَّارُ",
                    "The Forgiver",
                    "بڑا درگزر کرنے والا",
                    "The Forgiver, The One who forgives the sins of His slaves.",
                    "The Forgiver, The One who forgives the sins of His slaves time and time again."
                ),
                NamesModel(
                    "AL-QAHHAAR",
                    "ٱلْقَهَّارُ",
                    "The All Compelling Subduer",
                    "اپنی مخلوق پر کامل غلبہ اور اختیاررکھنے والا",
                    "This name will provide the person with inner peace and will lead the person to the correct place.",
                    "The Dominant, The One who has the perfect Power and is not unable over anything."
                ),
                NamesModel(
                    "AL-WAHHAB",
                    "ٱلْوَهَّابُ",
                    "The Best over",
                    "بے غرض بخشش اور سخاوت کرنےوالا",
                    "Reciting it frequently will remove poverty. Reciting it 40 times in the last Sajadah of Chasht prayer will relieve the person from starvation.",
                    "The One who is Generous in giving plenty without any return. He is everything that benefits whether Halal or Haram."
                ),
                NamesModel(
                    "AR-RAZZAQ",
                    "ٱلْرَّزَّاقُ",
                    "The Provider",
                    "حاجت روا",
                    "The person will be provided with livelihood by reciting this name.",
                    "The Sustainer, The Provider."
                ),
                NamesModel(
                    "AL-FATTAH",
                    "ٱلْفَتَّاحُ",
                    "The Opener",
                    "مشکلوں کو حل کرنے والا",
                    "The reciter of this name will be given success and victory in every aspect of his life.",
                    "The Opener, The Reliever, The Judge, The One who opens for His slaves the closed worldly and religious matters."
                ),
                NamesModel(
                    "AL-ALIM",
                    "ٱلْعَلِيمُ",
                    "The All Knowing",
                    "ہر چیز جاننے والا",
                    "The heart of the reciter will be enlightened with the light of Nur.",
                    "The Knowledgeable; The One nothing is absent from His knowledge"
                ),
                NamesModel(
                    "AL-QAABID",
                    "ٱلْقَابِضُ",
                    "The Constrictor",
                    "ہر شے پر قبضہ رکھنے والا",
                    "This finishes poverty from the house if it is written, and eaten on 4 pieces of food till 40 days.",
                    "The Constrictor, The Withholder, The One who constricts the sustenance by His wisdom and expands and widens it with His Generosity and Mercy."
                ),
                NamesModel(
                    "AL-BAASIT",
                    "ٱلْبَاسِطُ",
                    "The Expander, The Munificent",
                    "وسعت دینے والا",
                    "Repeating this name 10 times after Chasht prayer and rubbing hands with a face will no longer be dependent upon others.",
                    "The Englarger, The One who constricts the sustenance by His wisdom and expands and widens it with His Generosity and Mercy."
                ),
                NamesModel(
                    "AL-KHAAFID",
                    "ٱلْخَافِضُ",
                    "The Abaser",
                    "پست کرنے والا",
                    "Allah will fulfill the need of the person who recites it 500 times. It also acts as a guard from all enemies if a group of people sit in the gathering on the fourth day of fasting and recite this name 70 times each.",
                    "The Abaser, The One who lowers whoever He willed by His Destruction and raises whoever He willed by His Endowment."
                ),
                NamesModel(
                    "AR-RAFI",
                    "ٱلْرَّافِعُ",
                    "The Exalter",
                    "وہ جو بلندیاں عطا کرتا ہے",
                    "The one who recites this name 101 times day and night will get wealthier and will be highly regarded in merit.",
                    "The Exalter, The Elevator, The One who lowers whoever He willed by His Destruction and raises whoever He willed by His Endowment."
                ),
                NamesModel(
                    "AL-MU’IZZ",
                    "ٱلْمُعِزُّ",
                    "The Giver of Honor",
                    "عزت دینے والا",
                    "Reciting this name 140 times after Maghrib prayer either on Monday or on Friday, Allah will make him majestic in the eyes of other people.",
                    "He gives esteem to whoever He willed, hence there is no one to degrade Him; And He degrades whoever He willed, hence there is no one to give Him esteem."
                ),
                NamesModel(
                    "AL-MUZIL",
                    "ٱلْمُذِلُّ",
                    "The Giver of Dishonor",
                    "ذلت سینے والا",
                    "Reciting this name 140 times after Maghrib prayer either on Monday or on Friday, Allah will make him majestic in the eyes of other people.",
                    "The Dishonourer, The Humiliator, He gives esteem to whoever He willed, hence there is no one to degrade Him; And He degrades whoever He willed, hence there is no one to give Him esteem."
                ),
                NamesModel(
                    "AS-SAMI’",
                    "ٱلْسَّمِيعُ",
                    "The All Hearing",
                    "بندوں کی سننے والا",
                    "Allah will fulfill the desire of a person who recites this name 500, 100, or 50 times on Thursday after the Chasht prayer.",
                    "The Hearer, The One who Hears all things that are heard by His Eternal Hearing without an ear, instrument or organ"
                ),
                NamesModel(
                    "AL-BASEER",
                    "ٱلْبَصِيرُ",
                    "The All Seeing",
                    "ہر چیز کو دیکھنے والا",
                    "For the enlightenment of heart and soul, recite this name 100 times after the Jummah prayer.",
                    "The All-Noticing, The One who Sees all things that are seen by His Eternal Seeing without a pupil or any other instrument."
                ),
                NamesModel(
                    "AL-HAKAM",
                    "ٱلْحَكَمُ",
                    "The Judge, The Arbitrator",
                    "انصاف کرنے والا",
                    "Secrets will be revealed to the person who recites this name frequently at night.",
                    "The Judge, He is the Ruler and His judgment is His Word."
                ),
                NamesModel(
                    "AL-ADL",
                    "ٱلْعَدْلُ",
                    "The Utterly Just",
                    "عدل کرنے والا",
                    "People will obey you if you will write this name on a piece of bread on Friday.",
                    "The Just, The One who is entitled to do what He does."
                ),
                NamesModel(
                    "AL-LATEEF",
                    "ٱلْلَّطِيفُ",
                    "The Subtly Kind, The subtle one",
                    "بڑا لطیف و کرم کرنے والا",
                    "To make your affairs get settled accordingly to your will, recite this name 133 times daily.",
                    "The Subtle One, The Gracious, The One who is kind to His slaves and endows upon them."
                ),
                NamesModel(
                    "AL-KHABEER",
                    "ٱلْخَبِيرُ",
                    "The All Aware",
                    "باخبر اور آگاہ",
                    "Reciting this name regularly will make a person a righteous man who is indulged in wrong things.",
                    "The One who knows the truth of things."
                ),
                NamesModel(
                    "AL-HALEEM",
                    "ٱلْحَلِيمُ",
                    "The Forbearing, The Indulgent",
                    "بڑا بردبار اور برداشت کرنے والا",
                    "Write this name on a piece of paper and wash it with water. Use that water for sprinkling things. This will keep things safe from all types of damages.",
                    "The Forebearing, The One who delays the punishment for those who deserve it and then He might forgive them."
                ),
                NamesModel(
                    "AL-AZEEM",
                    "ٱلْعَظِيمُ",
                    "The Magnificent, The Great One",
                    "بڑی بزرگی والا",
                    "To earn respect and honor, recite this name several times.",
                    "The Great One, The Mighty, The One deserving the attributes of Exaltment, Glory, Extolement, and Purity from all imperfection."
                ),
                NamesModel(
                    "AL-GHAFOOR",
                    "ٱلْغَفُورُ",
                    "The All Forgiving",
                    "بڑآ بخشش کرنے والا",
                    "The All-Forgiving, The Forgiving, The One who forgives a lot.",
                    "The All-Forgiving, The Forgiving, The One who forgives a lot."
                ),
                NamesModel(
                    "ASH-SHAKOOR",
                    "ٱلْشَّكُورُ",
                    "The Appreciative",
                    "بڑا قدر کرنے والا",
                    "The person will be relieved from all the suffering if he recites this name 41 times daily.",
                    "The Grateful, The Appreciative, The One who gives a lot of reward for a little obedience"
                ),
                NamesModel(
                    "AL-ALIYY",
                    "ٱلْعَلِيُّ",
                    "The Most High",
                    "بڑی بلندیوں والا",
                    "The one who keeps this name written on a piece of paper will achieve a high rank and success in all his work.",
                    "The Most High, The One who is clear from the attributes of the creatures."
                ),
                NamesModel(
                    "AL-KABEER",
                    "ٱلْكَبِيرُ",
                    "The Most Great",
                    "بہت بڑا",
                    "The reciter of this name 100 times daily will be esteemed by every one.",
                    "The Most Great, The Great, The One who is greater than everything in status."
                ),
                NamesModel(
                    "AL-HAFEEZ",
                    "ٱلْحَفِيظُ",
                    "The Preserver",
                    "سب کا محافظ، حفاظ تکرنے والا",
                    "Recite this name and do a Damm on water. Give the water to the ill-mannered child. He will become obedient.",
                    "The Preserver, The Protector, The One who protects whatever and whoever He willed to protect."
                ),
                NamesModel(
                    "AL-MUQEET",
                    "ٱلْمُقِيتُ",
                    "The Nourisher, The Maintainer",
                    "سب کو روزی اور توانائی دینے والا",
                    "gives strength and nourishment to His creations and maintains all that exists",
                    "The Maintainer, The Guardian, The Feeder, The One who has the Power."
                ),
                NamesModel(
                    "AL-HASEEB",
                    "ٱلْحَسِيبُ",
                    "The Reckoner",
                    "بڑا شمار کنندہ",
                    "The Ever-Reckoner, The One who takes account of all actions and reckons them on the day of judgment.",
                    "The Reckoner, The One who gives the satisfaction."
                ),
                NamesModel(
                    "AL-JALEEL",
                    "ٱلْجَلِيلُ",
                    "The Sublime One",
                    "بلند مرتبے والا",
                    "Repeating this name frequently will help a person attain respect and honor.",
                    "The Sublime One, The Beneficent, The One who is attributed with greatness of Power and Glory of status."
                ),
                NamesModel(
                    "AL-KAREEM",
                    "ٱلْكَرِيمُ",
                    "The Bountiful, The Generous",
                    "بڑا کرم کرنے والا",
                    "To earn a lot of respect in this world and Hereafter, recite this name many times before going to sleep.",
                    "The Generous One, The Gracious, The One who is attributed with greatness of Power and Glory of status."
                ),
                NamesModel(
                    "AR-RAQEEB",
                    "ٱلْرَّقِيبُ",
                    "The Watchful",
                    "بڑا نگہبان",
                    "Recite this name seven times and do a Damm on yourself or your family. This will ensure safety under Allah’s protection.",
                    "The Watcher, The One that nothing is absent from Him. Hence it’s meaning is related to the attribute of Knowledge."
                ),
                NamesModel(
                    "AL-MUJEEB",
                    "ٱلْمُجِيبُ",
                    "The Responsive, The Answerer",
                    "دعائیں قبول کرنے والا",
                    "If you want an answer to any of your appeals, then you will get it if you recite this name frequently.",
                    "The Responsive, The Hearkener, The One who answers the one in need if he asks Him and rescues the yearner if he calls upon Him."
                ),
                NamesModel(
                    "AL-WAASI’",
                    "ٱلْوَاسِعُ",
                    "The Vast, The All Encompassing, The All-Embracing",
                    "بڑی وسعت والا",
                    "Allah opens the doors of income if someone recites this name many times. His difficulties in earning be vanished.",
                    "The Vast, The All-Embracing, The Knowledgeable."
                ),
                NamesModel(
                    "AL-HAKEEM",
                    "ٱلْحَكِيمُ",
                    "The Wise",
                    "بڑی حکمت والا",
                    "This name, when recited, removes the difficulties of the work.",
                    "The Wise, The Judge of Judges, The One who is correct in His doings."
                ),
                NamesModel(
                    "AL-WADUD",
                    "ٱلْوَدُودُ",
                    "The Loving, The Kind One",
                    "بڑا محبت کرنے والا",
                    "This name helps in resolving a disagreement between two people if one gives the other person food after reciting this name 1000 times in his food.",
                    "The One who loves His believing slaves and His believing slaves love Him. His love to His slaves is His Will to be merciful to them and praise them"
                ),
                NamesModel(
                    "AL-MAJEED",
                    "ٱلْمَجِيدُ",
                    "The Most Glorious One",
                    "بڑی بزرگی والا",
                    "This name bestows a person with glory.",
                    "The Most Glorious One, The One who is with perfect Power, High Status, Compassion, Generosity and Kindness."
                ),
                NamesModel(
                    "AL-BA’ITH",
                    "ٱلْبَاعِثُ",
                    "The Raiser of Dead, The Resurrector",
                    "مردوں کو زندہ کرنے والا",
                    "This name makes a person God-fearing and therefore, it leads him to the righteous path.",
                    "The Resurrector, The Raiser (from death), The One who resurrects His slaves after death for reward and/or punishment."
                ),
                NamesModel(
                    "ASH-SHAHEED",
                    "ٱلْشَّهِيدُ",
                    "The Witness",
                    "حاضر و ناظر",
                    "Recite this name 21 times with the hand placed on the head of the disobedient person. Insha’Allah, he will become obedient.",
                    "The Witness, The One who nothing is absent from Him."
                ),
                NamesModel(
                    "AL-HAQQ",
                    "ٱلْحَقُّ",
                    "The Truth, The Real",
                    "برحق و برقرار",
                    "If you lost something, then recite this name.",
                    "The Truth, The True, The One who truly exists."
                ),
                NamesModel(
                    "AL-WAKEEL",
                    "ٱلْوَكِيلُ",
                    "The Trustee, The Dependable",
                    "بڑا کار ساز",
                    "Allah will protect that person from drowning or burning in the fire if he recites this name frequently.",
                    "The Trustee, The One who gives the satisfaction and is relied upon."
                ),
                NamesModel(
                    "AL-QAWWIYY",
                    "ٱلْقَوِيُّ",
                    "The Most Strong",
                    "بڑی طاقت و قوت والا",
                    "This keeps a person safe from the harm of the enemy if he is unable to defeat the enemy.",
                    "The Most Strong, The Strong, The One with the complete Power"
                ),
                NamesModel(
                    "AL-MATEEN",
                    "ٱلْمَتِينُ",
                    "The Firm One, The Steadfast",
                    "انتہائی مضبوط و مستحکم",
                    "This helps a person to get rid of all types of troubles.",
                    "The One with extreme Power which is un-interrupted and He does not get tired."
                ),
                NamesModel(
                    "AL-WALIYY",
                    "ٱلْوَلِيُّ",
                    "The Protector, Patron and Helper, The Protecting friend",
                    "The Protecting Friend, The Supporter.",
                    "Reciting this name makes the person closer to Allah.",
                    "The Protecting Friend, The Supporter."
                ),
                NamesModel(
                    "AL-HAMEED",
                    "ٱلْحَمِيدُ",
                    "The All Praiseworthy",
                    "تعریف کے لائق",
                    "The one who recites this name will be praised and loved.",
                    "The Praiseworthy, The praised One who deserves to be praised."
                ),
                NamesModel(
                    "AL-MUHSEE",
                    "ٱلْمُحْصِيُ",
                    "The Reckoner",
                    "اپنے علم اور شمار میں رکھنے والا",
                    "This name provides ease to the person if he is afraid of being questioned on the Day of Resurrection.",
                    "The Counter, The Reckoner, The One who the count of things are known to him."
                ),
                NamesModel(
                    "AL-MUBDI",
                    "ٱلْمُبْدِئُ",
                    "The Originator",
                    "عدم سے عالم کو وجود لانے والا",
                    "A pregnant woman will be safe from danger while aborting if she repeats this name several times.",
                    "The One who started the human being. That is, He created him."
                ),
                NamesModel(
                    "AL-MUEED",
                    "ٱلْمُعِيدُ",
                    "The Restorer",
                    "پناہ دینے والا",
                    "Reciting this name 70 times will bring the person who has left home within 7 days, safe and secure.",
                    "The Reproducer, The One who brings back the creatures after death"
                ),
                NamesModel(
                    "AL-MUHYI",
                    "ٱلْمُحْيِى",
                    "The Giver of Life",
                    "زندگی دینے والا",
                    "This name reduces the burden of a person if recited 7 times every day.",
                    "The Restorer, The Giver of Life, The One who took out a living human from semen that does not have a soul. He gives life by giving the souls back to the worn out bodies on the resurrection day and He makes the hearts alive by the light of knowledge."
                ),
                NamesModel(
                    "AL-MUMEET",
                    "ٱلْمُمِيتُ",
                    "The Creator of Death",
                    "موت دینے والا",
                    "This name destroys the enemy completely.",
                    "The Creator of Death, The Destroyer, The One who renders the living dead."
                ),
                NamesModel(
                    "AL-HAYYU",
                    "ٱلْحَىُّ",
                    "The Alive",
                    "ہمیشہ ہمیشہ زندہ رہنے والا",
                    "The reciter of this name will have a long life.",
                    "The Alive, The One attributed with a life that is unlike our life and is not that of a combination of soul, flesh or blood."
                ),
                NamesModel(
                    "AL-QAYYOOM",
                    "ٱلْقَيُّومُ",
                    "The Self Subsisting Sustainer of All",
                    "قائم رکھنے اور سنبھالنے والا",
                    "The one repeating this name will remain active.",
                    "The One who remains and does not end."
                ),
                NamesModel(
                    "AL-WAAJID",
                    "ٱلْوَاجِدُ",
                    "The Finder",
                    "ہر چیز کا پانے والا",
                    "This name increases the richness of the heart.",
                    "The Perceiver, The Finder, The Rich who is never poor. Al-Wajd is Richness."
                ),
                NamesModel(
                    "AL-MAAJID",
                    "ٱلْمَاجِدُ",
                    "The Noble",
                    "بزرگی اور بڑائی والا",
                    "This name enlightens the heart of its reciter.",
                    "The Glorious, He who is Most Glorious."
                ),
                NamesModel(
                    "AL-WAAHID",
                    "ٱلْوَاحِدُ",
                    "The Unique One",
                    "بے مثال، اکیلا",
                    "Reciting this name 1000 times in silence alone will vanish the fear from the heart.",
                    "The Unique, The One, The One without a partner"
                ),
                NamesModel(
                    "AL-AHAD",
                    "ٱلْأَحَد",
                    "The One",
                    "اکیلا",
                    "Secrets will be revealed to the person who recites this name 1000 times.",
                    "The One"
                ),
                NamesModel(
                    "AS-SAMAD",
                    "ٱلْصَّمَدُ",
                    "The Eternal",
                    "بے نیاز جو کسی کام کا محتاج نہیں",
                    "Allah will fulfill all the needs of the person who recites this name many times.",
                    "The Eternal, The Independent, The Master who is relied upon in matters and reverted to in ones needs."
                ),
                NamesModel(
                    "AL-QAADIR",
                    "ٱلْقَادِرُ",
                    "The All Able",
                    "بڑی قدرت والا",
                    "Allah fulfills all the desires of the person who recites this name often.",
                    "The Able, The Capable, The One attributed with Power."
                ),
                NamesModel(
                    "AL-MUQTADIR",
                    "ٱلْمُقْتَدِرُ",
                    "The Powerful",
                    "بڑی قدرت والا",
                    "The reciter will become aware of the truth.",
                    "The Powerful, The Dominant, The One with the perfect Power that nothing is withheld from Hi"
                ),
                NamesModel(
                    "AL-MUQADDIM",
                    "ٱلْمُقَدِّمُ",
                    "The Expediter, He who brings forward",
                    "بڑی قدرت والا",
                    "Reciting this name on the battlefield removes all the fear and keeps the person safe from harm.",
                    "The Expediter, The Promoter, The One who puts things in their right places. He makes ahead what He wills and delays what He wills."
                ),
                NamesModel(
                    "AL-MU’AKHKHIR",
                    "ٱلْمُؤَخِّرُ",
                    "The Delayer, He who puts far away",
                    "پیچھے رکھنے والا",
                    "Reciting this name in the heart 100 times enriches the person’s heart with the love of Allah. All his worldly desires will be removed as no other love will ever replace his heart.",
                    "The Delayer, the Retarder, The One who puts things in their right places. He makes ahead what He wills and delays what He wills."
                ),
                NamesModel(
                    "AL-AWWAL",
                    "ٱلأَوَّلُ",
                    "The First",
                    "سب سے پہلے",
                    "If recited 40 times for 40 days, it will give a child to a family who is not blessed with one. Moreover, a traveler will reach home safe and sound if he recites this name 1000 times on Friday.",
                    "The First, The One whose Existence is without a beginning."
                ),
                NamesModel(
                    "AL-AKHIR",
                    "ٱلْآخِرُ",
                    "The Last",
                    "سب کے بعد",
                    "The reciter of this name will have a good life and a good death.",
                    "The Last, The One whose Existence is without an end."
                ),
                NamesModel(
                    "AZ-ZAAHIR",
                    "ٱلْظَّاهِرُ",
                    "The Manifest, The All Victorious",
                    "ظاہر و آشکار",
                    "The reciter’s heart will be enlightened with Noor (the divine light) if this name is recited 15 times after the Jummah prayer on Friday.",
                    "The Manifest, The One that nothing is above Him and nothing is underneath Him, hence He exists without a place. He, The Exalted, His Existence is obvious by proofs and He is clear from the delusions of attributes of bodies."
                ),
                NamesModel(
                    "AL-BAATIN",
                    "ٱلْبَاطِنُ",
                    "The Hidden, The All Encompassing",
                    "پوشیدہ و نہاں",
                    "With the recitation of this name only three times every day, he will be able to know the truth in all things.",
                    "The Hidden, The One that nothing is above Him and nothing is underneath Him, hence He exists without a place. He, The Exalted, His Existence is obvious by proofs and He is clear from the delusions of attributes of bodies."
                ),
                NamesModel(
                    "AL-WAALI",
                    "ٱلْوَالِي",
                    "The Patron, The Governor",
                    "سر پرست، متصرف",
                    "This name keeps the house safe from all dangers.",
                    "The Governor, The One who owns things and manages them."
                ),
                NamesModel(
                    "AL-MUTA’ALI",
                    "ٱلْمُتَعَالِي",
                    "The Most Exalted",
                    "سب سے بلند و برتر",
                    "Whosoever recites this name will become closer to Allah.",
                    "The Most Exalted, The High Exalted, The One who is clear from the attributes of the creation."
                ),
                NamesModel(
                    "AL-BARR",
                    "ٱلْبَرُّ",
                    "The Source of All Goodness",
                    "تمام اچھائیوں کا سر چشمہ",
                    "This name will make the future of the child of reciter free from misfortune.",
                    "The Source of All Goodness, The Righteous, The One who is kind to His creatures, who covered them with His sustenance and specified whoever He willed among them by His support, protection, and special mercy."
                ),
                NamesModel(
                    "AT-TAWWAAB",
                    "ٱلْتَّوَّابُ",
                    "The Acceptor of Repentance",
                    "توبہ قبول کرنے والا",
                    "Dua’s are accepted if this name is recited frequently.",
                    "The Relenting, The One who grants repentance to whoever He willed among His creatures and accepts his repentance."
                ),
                NamesModel(
                    "AL-MUNTAQIM",
                    "ٱلْمُنْتَقِمُ",
                    "The Avenger",
                    "بدلہ لینے والا",
                    "This helps gain victory against enemies.",
                    "The Avenger, The One who victoriously prevails over His enemies and punishes them for their sins. It may mean the One who destroys them."
                ),
                NamesModel(
                    "AL-AFUWW",
                    "ٱلْعَفُوُّ",
                    "The Pardoner, The Most Forgiving of Sins",
                    "The Forgiver, The One with wide forgiveness.",
                    "This name helps a person in the forgiveness of all his sins.",
                    "The Forgiver, The One with wide forgiveness."
                ),
                NamesModel(
                    "AR-RA’OOF",
                    "ٱلْرَّؤُفُ",
                    "The Compassionate, The All Pitying",
                    "بڑا مشفق و مہربان",
                    "Allah blesses the one who recites this name more often.",
                    "The Compassionate, The One with extreme Mercy. The Mercy of Allah is His will to endow upon whoever He willed among His creatures."
                ),
                NamesModel(
                    "MAALIK-UL-MULK",
                    "مَالِكُ ٱلْمُلْكُ",
                    "The Eternal Owner of All Sovereignty",
                    "ملکوں کا مالک",
                    "This name gives respect to its reciter among people.",
                    "The One who controls the Dominion and gives dominion to whoever He willed."
                ),
                NamesModel(
                    "ZUL-JALAALI-WAL-IKRAM",
                    "ذُو ٱلْجَلَالِ وَٱلْإِكْرَامُ",
                    "The Lord of Majesty and Bounty",
                    "عظمت و جلال  اور انعام و اکرام والا",
                    "This name removes poverty and makes a person rich.",
                    "The Lord of Majesty and Bounty, The One who deserves to be Exalted and not denied."
                ),
                NamesModel(
                    "AL-MUQSIT",
                    "ٱلْمُقْسِطُ",
                    "The Equitable, The Requiter",
                    "عدل و انصاف قائم رکھنے والا",
                    "This name provides protection from the harm of a devil.",
                    "The Equitable, The One who is Just in His judgment."
                ),
                NamesModel(
                    "AL-JAAMI’",
                    "ٱلْجَامِعُ",
                    "The Gatherer, The Unifier",
                    "جمع کرنے والا",
                    "With the power and glory of this name, you will be able to find lost things.",
                    "The Gatherer, The One who gathers the creatures on a day that there is no doubt about, that is the Day of Judgment."
                ),
                NamesModel(
                    "AL-GHANIYY",
                    "ٱلْغَنيُّ",
                    "The Self-Sufficient",
                    "The One who does not need the creation.",
                    "Reciting this name 70 times will make a person free from all needs.",
                    "The One who does not need the creation."
                ),
                NamesModel(
                    "AL-MUGHNI",
                    "ٱلْمُغْنِيُّ",
                    "The Enricher",
                    "خود کفیل و بےپرواہ",
                    "Reciting this name 1000 times for ten consecutive Fridays will make a person become self-sufficient.",
                    "The Enricher, The One who satisfies the necessities of the creatures."
                ),
                NamesModel(
                    "AL-MAANI’",
                    "ٱلْمَانِعُ",
                    "The Most Preventer",
                    "توانگر بنانے والا",
                    "Recitation of this name 20 times at bedtime provides a happy family life.",
                    "The Withholder."
                ),
                NamesModel(
                    "AD-DAARR",
                    "ٱلْضَّارُ",
                    "The Distresser, The Harmer",
                    "ضرر پہنچانے والا",
                    "This name helps a person in gaining peace if it is read 20 times on Friday nights.",
                    "The One who makes harm reach to whoever He willed and benefit to whoever He willed."
                ),
                NamesModel(
                    "AN-NAAFI’",
                    "ٱلْنَّافِعُ",
                    "The Propitious, The Benefactor",
                    "نفع پہنچانے والا",
                    "This name gives success on every good act if it is started with the recitation of this name 41 times.",
                    "The Propitious, The One who makes harm reach to whoever He willed and benefit to whoever He willed."
                ),
                NamesModel(
                    "AN-NOOR",
                    "ٱلْنُّورُ",
                    "The Light",
                    "نو راور انوار بخشنے والا",
                    "This name enlightens the inside of the person.",
                    "The Light, The One who guides."
                ),
                NamesModel(
                    "AL-HAADI",
                    "ٱلْهَادِي",
                    "The Guide",
                    "سیدھی راہ دکھانے والا",
                    "1100 times of the recitation of this name makes a person fulfill his needs.",
                    "The Guide, The One whom with His Guidance His believers were guided, and with His Guidance the living beings have been guided to what is beneficial for them and protected from what is harmful to them."
                ),
                NamesModel(
                    "AL-BADEE’",
                    "ٱلْبَدِيعُ",
                    "The Incomparable",
                    "بے مثال چیزوں کا پیدا کرنے والا",
                    "To gain relief from any type of distress, a person should recite this name 70,000 times.",
                    "The Incomparable, The One who created the creation and formed it without any preceding example."
                ),
                NamesModel(
                    "AL-BAAQI'",
                    "ٱلْبَاقِي",
                    "The Everlasting",
                    "ہمیشہ باقی رہنے والا",
                    "To ensure that all your good deeds are accepted, recite this name 100 times every Friday night.",
                    "The Everlasting, The One that the state of non-existence is impossible for Him."
                ),
                NamesModel(
                    "AL-WAARIS",
                    "ٱلْوَارِثُ",
                    "The Supreme Inheritor of All",
                    "سب کے بعد موجود رہنے والا",
                    "A person will remain safe from sorrow and distress if he recites this name 100 times after the sunrise.",
                    "The Heir, The One whose Existence remains."
                ),
                NamesModel(
                    "AR-RASHEED",
                    "ٱلْرَّشِيدُ",
                    "The Guide to The Right Path",
                    "صحیح راہ پر چلانے والا",
                    "To complete a task you are unable to do, recite this name 1000 times between Maghrib and Isha prayer.",
                    "He Guide to the Right Path, The One who guides."
                ),
                NamesModel(
                    "AS-SABOOR",
                    "ٱلْصَّبُورُ",
                    "The Most Patient",
                    "بڑے صبر و تحمل والا",
                    "The person will be rescued from his difficulty if he recites this name 3000 times.",
                    "The Patient, The One who does not quickly punish the sinners."
                )
            )
        }

    }


    suspend fun getMuhammadAttributes(): List<NamesModel> {
        return withContext(Dispatchers.IO) {
            listOf(
                NamesModel(
                    "Muhammad",
                    "مُحَمَّدُ",
                    "The Praised One",
                    "محمود، تعریف شدہ",
                    "The praised and praiseworthy, the name signifies admiration and respect."
                ),
                NamesModel(
                    "Ahmad",
                    "أَحْمَدُ",
                    "Most Praiseworthy",
                    "سب سے زیادہ قابل تعریف",
                    "One who deserves the highest praise, another name for Prophet Muhammad."
                ),
                NamesModel(
                    "Al-Amin",
                    "ٱلْأَمِيْنُ",
                    "The Trustworthy",
                    "امانتدار",
                    "Known for his honesty and trustworthiness, a quality of Prophet Muhammad."
                ),
                NamesModel(
                    "Al-Mustafa",
                    "ٱلْمُصْطَفَىٰ",
                    "The Chosen One",
                    "مختار",
                    "Chosen by Allah for Prophethood and guidance for humanity."
                ),
                NamesModel(
                    "Ar-Rasool",
                    "ٱلرَّسُوْلُ",
                    "The Messenger",
                    "رسول، پیغمبر",
                    "Sent by Allah as the final messenger for the guidance of mankind."
                ),
                NamesModel(
                    "AL-MU’MIN",
                    "ٱلْمُؤْمِنُ",
                    "The guardian of faith",
                    "آفات و وعذاب سے امن و امان رکھنے والا",
                    "Reciting it 631 times will keep you safe from anguish."
                ),
                NamesModel(
                    "AL-MUHAYMIN",
                    "ٱلْمُهَيْمِنُ",
                    "The protector",
                    "حفاظت کرنے والا",
                    "This purifies the soul of a person if it is recited 100 times after taking a bath and offering two rakaats of prayer."
                ),
                NamesModel(
                    "AL-AZIZ",
                    "ٱلْعَزِيزُ",
                    "The Almighty",
                    "بڑے اقتدار والا",
                    "Recitation of this name 41 times after Fajr prayer will make the person independent from others and will earn respect."
                ),
                NamesModel(
                    "AL-JABBAR",
                    "ٱلْجَبَّارُ",
                    "The compeller",
                    "زبردست غلبہ رکھنے والا",
                    "Whoever recites this name several times will not be forced to do anything. He will be safe from cruelty and hardship."
                ),
                NamesModel(
                    "AL-MUTAKABBIR",
                    "ٱلْمُتَكَبِّرُ",
                    "The Majestic",
                    "عظمت و کبریائی کا سر چشمہ",
                    "The one who recites this name frequently will earn respect and gain success."
                ),
                NamesModel(
                    "AL-KHAALIQ",
                    "ٱلْخَالِقُ",
                    "The Creator",
                    "وجود بخشنے والا، پیدا کرنے والا",
                    "Allah will assign an angel to guide the person righteously if he recites this name 100 times continuously for a prescribed limit of 7 days."
                ),
                NamesModel(
                    "AL-BAARI",
                    "ٱلْبَارِئُ",
                    "The Evolver, The Maker",
                    "ہر چیز کو عدم سے وجود میں لانے والا",
                    "This name only signifies that Allah created all things in proportion."
                ),
                NamesModel(
                    "AL-MUSAWWIR",
                    "ٱلْمُصَوِّرُ",
                    "The Fashioner of Forms",
                    "مخلوقات کی صورت گری کرنے والا",
                    "Recite this name 21 times and do a Damm on water. Continue this for 7 consecutive days. Use the water for breaking the fast. Insha’Allah, the woman will soon be blessed with a child."
                ),
                NamesModel(
                    "AL-GHAFFAAR",
                    "ٱلْغَفَّارُ",
                    "The Forgiver",
                    "بڑا درگزر کرنے والا",
                    "The Forgiver, The One who forgives the sins of His slaves."
                ),
                NamesModel(
                    "AL-QAHHAAR",
                    "ٱلْقَهَّارُ",
                    "The All Compelling Subduer",
                    "اپنی مخلوق پر کامل غلبہ اور اختیاررکھنے والا",
                    "This name will provide the person with inner peace and will lead the person to the correct place."
                ),
                NamesModel(
                    "AL-WAHHAB",
                    "ٱلْوَهَّابُ",
                    "The Best over",
                    "بے غرض بخشش اور سخاوت کرنےوالا",
                    "Reciting it frequently will remove poverty. Reciting it 40 times in the last Sajadah of Chasht prayer will relieve the person from starvation."
                ),
                NamesModel(
                    "AR-RAZZAQ",
                    "ٱلْرَّزَّاقُ",
                    "The Provider",
                    "حاجت روا",
                    "The person will be provided with livelihood by reciting this name."
                ),
                NamesModel(
                    "AL-FATTAH",
                    "ٱلْفَتَّاحُ",
                    "The Opener",
                    "مشکلوں کو حل کرنے والا",
                    "The reciter of this name will be given success and victory in every aspect of his life."
                ),
                NamesModel(
                    "AL-ALIM",
                    "ٱلْعَلِيمُ",
                    "The All Knowing",
                    "ہر چیز جاننے والا",
                    "The heart of the reciter will be enlightened with the light of Nur."
                ),
                NamesModel(
                    "AL-QAABID",
                    "ٱلْقَابِضُ",
                    "The Constrictor",
                    "ہر شے پر قبضہ رکھنے والا",
                    "This finishes poverty from the house if it is written, and eaten on 4 pieces of food till 40 days."
                ),
                NamesModel(
                    "AL-BAASIT",
                    "ٱلْبَاسِطُ",
                    "The Expander, The Munificent",
                    "وسعت دینے والا",
                    "Repeating this name 10 times after Chasht prayer and rubbing hands with a face will no longer be dependent upon others."
                ),
                NamesModel(
                    "AL-KHAAFID",
                    "ٱلْخَافِضُ",
                    "The Abaser",
                    "پست کرنے والا",
                    "Allah will fulfill the need of the person who recites it 500 times. It also acts as a guard from all enemies if a group of people sit in the gathering on the fourth day of fasting and recite this name 70 times each."
                ),
                NamesModel(
                    "AR-RAFI",
                    "ٱلْرَّافِعُ",
                    "The Exalter",
                    "وہ جو بلندیاں عطا کرتا ہے",
                    "The one who recites this name 101 times day and night will get wealthier and will be highly regarded in merit."
                ),
                NamesModel(
                    "AL-MU’IZZ",
                    "ٱلْمُعِزُّ",
                    "The Giver of Honor",
                    "عزت دینے والا",
                    "Reciting this name 140 times after Maghrib prayer either on Monday or on Friday, Allah will make him majestic in the eyes of other people."
                ),
                NamesModel(
                    "AL-MUZIL",
                    "ٱلْمُذِلُّ",
                    "The Giver of Dishonor",
                    "ذلت سینے والا",
                    "Reciting this name 140 times after Maghrib prayer either on Monday or on Friday, Allah will make him majestic in the eyes of other people."
                ),
                NamesModel(
                    "AS-SAMI’",
                    "ٱلْسَّمِيعُ",
                    "The All Hearing",
                    "بندوں کی سننے والا",
                    "Allah will fulfill the desire of a person who recites this name 500, 100, or 50 times on Thursday after the Chasht prayer."
                ),
                NamesModel(
                    "AL-BASEER",
                    "ٱلْبَصِيرُ",
                    "The All Seeing",
                    "ہر چیز کو دیکھنے والا",
                    "For the enlightenment of heart and soul, recite this name 100 times after the Jummah prayer."
                ),
                NamesModel(
                    "AL-HAKAM",
                    "ٱلْحَكَمُ",
                    "The Judge, The Arbitrator",
                    "انصاف کرنے والا",
                    "Secrets will be revealed to the person who recites this name frequently at night."
                ),
                NamesModel(
                    "AL-ADL",
                    "ٱلْعَدْلُ",
                    "The Utterly Just",
                    "عدل کرنے والا",
                    "People will obey you if you will write this name on a piece of bread on Friday."
                ),
                NamesModel(
                    "AL-LATEEF",
                    "ٱلْلَّطِيفُ",
                    "The Subtly Kind, The subtle one",
                    "بڑا لطیف و کرم کرنے والا",
                    "To make your affairs get settled accordingly to your will, recite this name 133 times daily."
                ),
                NamesModel(
                    "AL-KHABEER",
                    "ٱلْخَبِيرُ",
                    "The All Aware",
                    "باخبر اور آگاہ",
                    "Reciting this name regularly will make a person a righteous man who is indulged in wrong things."
                ),
                NamesModel(
                    "AL-HALEEM",
                    "ٱلْحَلِيمُ",
                    "The Forbearing, The Indulgent",
                    "بڑا بردبار اور برداشت کرنے والا",
                    "Write this name on a piece of paper and wash it with water. Use that water for sprinkling things. This will keep things safe from all types of damages."
                ),
                NamesModel(
                    "AL-AZEEM",
                    "ٱلْعَظِيمُ",
                    "The Magnificent, The Great One",
                    "بڑی بزرگی والا",
                    "To earn respect and honor, recite this name several times."
                ),
                NamesModel(
                    "AL-GHAFOOR",
                    "ٱلْغَفُورُ",
                    "The All Forgiving",
                    "بڑآ بخشش کرنے والا",
                    "The All-Forgiving, The Forgiving, The One who forgives a lot."
                ),
                NamesModel(
                    "ASH-SHAKOOR",
                    "ٱلْشَّكُورُ",
                    "The Appreciative",
                    "بڑا قدر کرنے والا",
                    "The person will be relieved from all the suffering if he recites this name 41 times daily."
                ),
                NamesModel(
                    "AL-ALIYY",
                    "ٱلْعَلِيُّ",
                    "The Most High",
                    "بڑی بلندیوں والا",
                    "The one who keeps this name written on a piece of paper will achieve a high rank and success in all his work."
                ),
                NamesModel(
                    "AL-KABEER",
                    "ٱلْكَبِيرُ",
                    "The Most Great",
                    "بہت بڑا",
                    "The reciter of this name 100 times daily will be esteemed by every one."
                ),
                NamesModel(
                    "AL-HAFEEZ",
                    "ٱلْحَفِيظُ",
                    "The Preserver",
                    "سب کا محافظ، حفاظ تکرنے والا",
                    "Recite this name and do a Damm on water. Give the water to the ill-mannered child. He will become obedient."
                ),
                NamesModel(
                    "AL-MUQEET",
                    "ٱلْمُقِيتُ",
                    "The Nourisher, The Maintainer",
                    "سب کو روزی اور توانائی دینے والا",
                    "gives strength and nourishment to His creations and maintains all that exists"
                ),
                NamesModel(
                    "AL-HASEEB",
                    "ٱلْحَسِيبُ",
                    "The Reckoner",
                    "بڑا شمار کنندہ",
                    "The Ever-Reckoner, The One who takes account of all actions and reckons them on the day of judgment."
                ),
                NamesModel(
                    "AL-JALEEL",
                    "ٱلْجَلِيلُ",
                    "The Sublime One",
                    "بلند مرتبے والا",
                    "Repeating this name frequently will help a person attain respect and honor."
                ),
                NamesModel(
                    "AL-KAREEM",
                    "ٱلْكَرِيمُ",
                    "The Bountiful, The Generous",
                    "بڑا کرم کرنے والا",
                    "To earn a lot of respect in this world and Hereafter, recite this name many times before going to sleep."
                ),
                NamesModel(
                    "AR-RAQEEB",
                    "ٱلْرَّقِيبُ",
                    "The Watchful",
                    "بڑا نگہبان",
                    "Recite this name seven times and do a Damm on yourself or your family. This will ensure safety under Allah’s protection."
                ),
                NamesModel(
                    "AL-MUJEEB",
                    "ٱلْمُجِيبُ",
                    "The Responsive, The Answerer",
                    "دعائیں قبول کرنے والا",
                    "If you want an answer to any of your appeals, then you will get it if you recite this name frequently."
                ),
                NamesModel(
                    "AL-WAASI’",
                    "ٱلْوَاسِعُ",
                    "The Vast, The All Encompassing, The All-Embracing",
                    "بڑی وسعت والا",
                    "Allah opens the doors of income if someone recites this name many times. His difficulties in earning be vanished."
                ),
                NamesModel(
                    "AL-HAKEEM",
                    "ٱلْحَكِيمُ",
                    "The Wise",
                    "بڑی حکمت والا",
                    "This name, when recited, removes the difficulties of the work."
                ),
                NamesModel(
                    "AL-WADUD",
                    "ٱلْوَدُودُ",
                    "The Loving, The Kind One",
                    "بڑا محبت کرنے والا",
                    "This name helps in resolving a disagreement between two people if one gives the other person food after reciting this name 1000 times in his food."
                ),
                NamesModel(
                    "AL-MAJEED",
                    "ٱلْمَجِيدُ",
                    "The Most Glorious One",
                    "بڑی بزرگی والا",
                    "This name bestows a person with glory."
                ),
                NamesModel(
                    "AL-BA’ITH",
                    "ٱلْبَاعِثُ",
                    "The Raiser of Dead, The Resurrector",
                    "مردوں کو زندہ کرنے والا",
                    "This name makes a person God-fearing and therefore, it leads him to the righteous path."
                ),
                NamesModel(
                    "ASH-SHAHEED",
                    "ٱلْشَّهِيدُ",
                    "The Witness",
                    "حاضر و ناظر",
                    "Recite this name 21 times with the hand placed on the head of the disobedient person. Insha’Allah, he will become obedient."
                ),
                NamesModel(
                    "AL-HAQQ",
                    "ٱلْحَقُّ",
                    "The Truth, The Real",
                    "برحق و برقرار",
                    "If you lost something, then recite this name."
                ),
                NamesModel(
                    "AL-WAKEEL",
                    "ٱلْوَكِيلُ",
                    "The Trustee, The Dependable",
                    "بڑا کار ساز",
                    "Allah will protect that person from drowning or burning in the fire if he recites this name frequently."
                ),
                NamesModel(
                    "AL-QAWWIYY",
                    "ٱلْقَوِيُّ",
                    "The Most Strong",
                    "بڑی طاقت و قوت والا",
                    "This keeps a person safe from the harm of the enemy if he is unable to defeat the enemy."
                ),
                NamesModel(
                    "AL-MATEEN",
                    "ٱلْمَتِينُ",
                    "The Firm One, The Steadfast",
                    "انتہائی مضبوط و مستحکم",
                    "This helps a person to get rid of all types of troubles."
                ),
                NamesModel(
                    "AL-WALIYY",
                    "ٱلْوَلِيُّ",
                    "مدد گار اور حمایتی",
                    "دوست",
                    "Reciting this name makes the person closer to Allah."
                ),
                NamesModel(
                    "AL-HAMEED",
                    "ٱلْحَمِيدُ",
                    "The All Praiseworthy",
                    "تعریف کے لائق",
                    "The one who recites this name will be praised and loved."
                ),
                NamesModel(
                    "AL-MUHSEE",
                    "ٱلْمُحْصِيُ",
                    "The Reckoner",
                    "اپنے علم اور شمار میں رکھنے والا",
                    "This name provides ease to the person if he is afraid of being questioned on the Day of Resurrection."
                ),
                NamesModel(
                    "AL-MUBDI",
                    "ٱلْمُبْدِئُ",
                    "The Originator",
                    "پیدا کرنے والا",
                    "A pregnant woman will be safe from danger while aborting if she repeats this name several times."
                ),
                NamesModel(
                    "AL-MUEED",
                    "ٱلْمُعِيدُ",
                    "The Restorer",
                    "پہلی بار پیدا کرنے والا",
                    "Reciting this name 70 times will bring the person who has left home within 7 days, safe and secure."
                ),
                NamesModel(
                    "AL-MUHYI",
                    "ٱلْمُحْيِى",
                    "The Giver of Life",
                    "زندگی دینے والا",
                    "This name reduces the burden of a person if recited 7 times every day."
                ),
                NamesModel(
                    "AL-MUMEET",
                    "ٱلْمُمِيتُ",
                    "The Creator of Death",
                    "موت دینے والا",
                    "This name destroys the enemy completely."
                ),
                NamesModel(
                    "AL-HAYYU",
                    "ٱلْحَىُّ",
                    "The Alive",
                    "ہمیشہ ہمیشہ زندہ رہنے والا",
                    "The reciter of this name will have a long life."
                ),
                NamesModel(
                    "AL-QAYYOOM",
                    "ٱلْقَيُّومُ",
                    "قائم رکھنے اور سنبھالنے والا",
                    "The One who remains and does not end.",
                    "The one repeating this name will remain active."
                ),
                NamesModel(
                    "AL-WAAJID",
                    "ٱلْوَاجِدُ",
                    "The Finder",
                    "ہر چیز کا پانے والا",
                    "This name increases the richness of the heart."
                ),
                NamesModel(
                    "AL-MAAJID",
                    "ٱلْمَاجِدُ",
                    "The Noble",
                    "بزرگی اور بڑائی والا",
                    "This name enlightens the heart of its reciter."
                ),
                NamesModel(
                    "AL-WAAHID",
                    "ٱلْوَاحِدُ",
                    "The Unique One",
                    "بے مثال، اکیلا",
                    "Reciting this name 1000 times in silence alone will vanish the fear from the heart."
                ),
                NamesModel(
                    "AL-AHAD",
                    "ٱلْأَحَد",
                    "اکیلا",
                    "The One",
                    "Secrets will be revealed to the person who recites this name 1000 times."
                ),
                NamesModel(
                    "AS-SAMAD",
                    "ٱلْصَّمَدُ",
                    "The Eternal",
                    "بے نیاز جو کسی کام کا محتاج نہیں",
                    "Allah will fulfill all the needs of the person who recites this name many times."
                ),
                NamesModel(
                    "AL-QAADIR",
                    "ٱلْقَادِرُ",
                    "The All Able",
                    "بڑی قدرت والا",
                    "Allah fulfills all the desires of the person who recites this name often."
                ),
                NamesModel(
                    "AL-MUQTADIR",
                    "ٱلْمُقْتَدِرُ",
                    "The Powerful",
                    "بڑی قدرت والا",
                    "The reciter will become aware of the truth."
                ),
                NamesModel(
                    "AL-MUQADDIM",
                    "ٱلْمُقَدِّمُ",
                    "The Expediter, He who brings forward",
                    "بڑی قدرت والا",
                    "Reciting this name on the battlefield removes all the fear and keeps the person safe from harm."
                ),
                NamesModel(
                    "AL-MU’AKHKHIR",
                    "ٱلْمُؤَخِّرُ",
                    "The Delayer, He who puts far away",
                    "پیچھے رکھنے والا",
                    "Reciting this name in the heart 100 times enriches the person’s heart with the love of Allah. All his worldly desires will be removed as no other love will ever replace his heart."
                ),
                NamesModel(
                    "AL-AWWAL",
                    "ٱلأَوَّلُ",
                    "The First",
                    "سب سے پہلے",
                    "If recited 40 times for 40 days, it will give a child to a family who is not blessed with one. Moreover, a traveler will reach home safe and sound if he recites this name 1000 times on Friday."
                ),
                NamesModel(
                    "AL-AKHIR",
                    "ٱلْآخِرُ",
                    "The Last",
                    "سب کے بعد",
                    "The reciter of this name will have a good life and a good death."
                ),
                NamesModel(
                    "AZ-ZAAHIR",
                    "ٱلْظَّاهِرُ",
                    "The Manifest, The All Victorious",
                    "ظاہر و آشکار",
                    "The reciter’s heart will be enlightened with Noor (the divine light) if this name is recited 15 times after the Jummah prayer on Friday."
                ),
                NamesModel(
                    "AL-BAATIN",
                    "ٱلْبَاطِنُ",
                    "The Hidden, The All Encompassing",
                    "پوشیدہ و نہاں",
                    "With the recitation of this name only three times every day, he will be able to know the truth in all things."
                ),
                NamesModel(
                    "AL-WAALI",
                    "ٱلْوَالِي",
                    "The Patron, The Governor",
                    "سر پرست، متصرف",
                    "This name keeps the house safe from all dangers."
                ),
                NamesModel(
                    "AL-MUTA’ALI",
                    "ٱلْمُتَعَالِي",
                    "The Most Exalted",
                    "سب سے بلند و برتر",
                    "Whosoever recites this name will become closer to Allah."
                ),
                NamesModel(
                    "AL-BARR",
                    "ٱلْبَرُّ",
                    "The Source of All Goodness",
                    "تمام اچھائیوں کا سر چشمہ",
                    "This name will make the future of the child of reciter free from misfortune."
                ),
                NamesModel(
                    "AT-TAWWAAB",
                    "ٱلْتَّوَّابُ",
                    "The Acceptor of Repentance",
                    "توبہ قبول کرنے والا",
                    "Dua’s are accepted if this name is recited frequently."
                ),
                NamesModel(
                    "AL-MUNTAQIM",
                    "ٱلْمُنْتَقِمُ",
                    "The Avenger",
                    "بدلہ لینے والا",
                    "This helps gain victory against enemies."
                ),
                NamesModel(
                    "AL-AFUWW",
                    "ٱلْعَفُوُّ",
                    "معاف کرنے والا",
                    "The Forgiver, The One with wide forgiveness.",
                    "This name helps a person in the forgiveness of all his sins."
                ),
                NamesModel(
                    "AR-RA’OOF",
                    "ٱلْرَّؤُفُ",
                    "The Compassionate, The All Pitying",
                    "بڑا مشفق و مہربان",
                    "Allah blesses the one who recites this name more often."
                ),
                NamesModel(
                    "MAALIK-UL-MULK",
                    "مَالِكُ ٱلْمُلْكُ",
                    "The Eternal Owner of All Sovereignty",
                    "ملکوں کا مالک",
                    "This name gives respect to its reciter among people."
                ),
                NamesModel(
                    "ZUL-JALAALI-WAL-IKRAM",
                    "ذُو ٱلْجَلَالِ وَٱلْإِكْرَامُ",
                    "The Lord of Majesty and Bounty",
                    "عظمت و جلال  اور انعام و اکرام والا",
                    "This name removes poverty and makes a person rich."
                ),
                NamesModel(
                    "AL-MUQSIT",
                    "ٱلْمُقْسِطُ",
                    "The Equitable, The Requiter",
                    "عدل و انصاف قائم رکھنے والا",
                    "This name provides protection from the harm of a devil."
                ),
                NamesModel(
                    "AL-JAAMI’",
                    "ٱلْجَامِعُ",
                    "The Gatherer, The Unifier",
                    "جمع کرنے والا",
                    "With the power and glory of this name, you will be able to find lost things."
                ),
                NamesModel(
                    "AL-GHANIYY",
                    "ٱلْغَنيُّ",
                    "The Self-Sufficient",
                    "The One who does not need the creation.",
                    "Reciting this name 70 times will make a person free from all needs."
                ),
                NamesModel(
                    "AL-MUGHNI",
                    "ٱلْمُغْنِيُّ",
                    "The Enricher",
                    "خود کفیل و بےپرواہ",
                    "Reciting this name 1000 times for ten consecutive Fridays will make a person become self-sufficient."
                ),
                NamesModel(
                    "AL-MAANI’",
                    "ٱلْمَانِعُ",
                    "The Most Preventer",
                    "توانگر بنانے والا",
                    "Recitation of this name 20 times at bedtime provides a happy family life."
                ),
                NamesModel(
                    "AD-DAARR",
                    "ٱلْضَّارُ",
                    "The Distresser, The Harmer",
                    "ضرر پہنچانے والا",
                    "This name helps a person in gaining peace if it is read 20 times on Friday nights."
                ),
                NamesModel(
                    "AN-NAAFI’",
                    "ٱلْنَّافِعُ",
                    "The Propitious, The Benefactor",
                    "نفع پہنچانے والا",
                    "This name gives success on every good act if it is started with the recitation of this name 41 times."
                ),
                NamesModel(
                    "AN-NOOR", "ٱلْنُّورُ", "The Light",
                    "نو راور انوار بخشنے والا",
                    "This name enlightens the inside of the person."
                ),
                NamesModel(
                    "AL-HAADI",
                    "ٱلْهَادِي",
                    "The Guide",
                    "سیدھی راہ دکھانے والا",
                    "1100 times of the recitation of this name makes a person fulfill his needs."
                ),
                NamesModel(
                    "AL-BADEE’",
                    "ٱلْبَدِيعُ",
                    "The Incomparable",
                    "بے مثال چیزوں کا پیدا کرنے والا",
                    "To gain relief from any type of distress, a person should recite this name 70,000 times."
                ),
                NamesModel(
                    "AL-BAAQI'",
                    "ٱلْبَاقِي",
                    "The Everlasting",
                    "ہمیشہ باقی رہنے والا",
                    "To ensure that all your good deeds are accepted, recite this name 100 times every Friday night."
                ),
                NamesModel(
                    "AL-WAARIS",
                    "ٱلْوَارِثُ",
                    "The Supreme Inheritor of All",
                    "سب کے بعد موجود رہنے والا",
                    "A person will remain safe from sorrow and distress if he recites this name 100 times after the sunrise."
                ),
                NamesModel(
                    "AR-RASHEED",
                    "ٱلْرَّشِيدُ",
                    "The Guide to The Right Path",
                    "صحیح راہ پر چلانے والا",
                    "To complete a task you are unable to do, recite this name 1000 times between Maghrib and Isha prayer."
                ),
                NamesModel(
                    "AS-SABOOR",
                    "ٱلْصَّبُورُ",
                    "The Most Patient",
                    "بڑے صبر و تحمل والا",
                    "The person will be rescued from his difficulty if he recites this name 3000 times."
                )
            )
        }
    }


    suspend fun getQalma(): List<QalmaModel> {
        return withContext(Dispatchers.IO) {
            listOf(
                QalmaModel(
                    "1st Kalma",
                    "لَآ اِلٰهَ اِلَّا اﷲُ مُحَمَّدٌ رَّسُوْلُ اﷲِ",
                    "There is none worthy of worship except ALLAH, (and) Muhammad (P.B.U.H) is the Messenger of ALLAH."
                ),
                QalmaModel(
                    "2nd Kalma",
                    "اَشْهَدُ اَنْ لاَّ اِلٰهَ اِلاَّ اﷲُ وَحْدَهُ لَا شَرِيْکَ لَهُ وَاَشْهَدُ اَنَّ مُحَمَّدًا عَبْدُهُ وَرَسُوْلُهُِ",
                    "I bear witness that there is none worthy of worship except ALLAH, the One alone, without partner, and I bear witness that Muhammad (P.B.U.H) is His Servant and Messenger."
                ),
                QalmaModel(
                    "3rd Kalma",
                    "سُبْحَانَ اﷲِ وَالْحَمْدُِ ﷲِ وَلَآ اِلٰهَ اِلَّا اﷲُ وَاﷲُ اَکْبَرُ ط وَلَا حَوْلَ وَلَا قُوَّةَ اِلَّا بِاﷲِ الْعَلِيِ الْعَظِيْمِ",
                    "Glory be to ALLAH and all praise be to ALLAH and there is no worthy of worship except ALLAH, and ALLAH is the Greatest. And there is no might or power except with ALLAH, the Exalted, the Great One."
                ),
                QalmaModel(
                    "4th Kalma",
                    "لَآ اِلٰهَ اِلاَّ اﷲُ وَحْدَهُ لَاشَرِيْکَ لَهُ لَهُ الْمُلْکُ وَلَهُ الْحَمْدُ يُحْی وَيُمِيْتُ وَهُوَ حَيٌّ لَّا يَمُوْتُ اَبَدًا اَبَدًا ط ذُوالْجَلَالِ وَالْاِکْرَامِ ط بِيَدِهِ الْخَيْرُ ط وَهُوَعَلٰی کُلِّ شَيْئٍ قَدِيْرِ",
                    "There is none worthy of worship except ALLAH. He is alone and has no partner. To Him belongs the Kingdom and for Him is all praise. He gives life and causes death. And He is alive. He will not die, never, ever. Possessor of Majesty and Reverence. In His hand is all good and He has power over everything."
                ),
                QalmaModel(
                    "5th Kalma",
                    "اَسْتَغْفِرُ اﷲَ رَبِّيْ مِنْ کُلِّ ذَنْبٍ اَذْنَبْتُهُ عَمَدًا اَوْ خَطَاً سِرًّا اَوْ عَلَانِيَةً وَّاَتُوْبُ اِلَيْهِ مِنَ الذَّنْبِ الَّذِيْ اَعْلَمُ وَمِنَ الذَّنْبِ الَّذِيْ لَآ اَعْلَمُ ط اِنَّکَ اَنْتَ عَلَّامُ الْغُيُوْبِ وَسَتَّارُ الْعُيُوْبِ وَغَفَّارُ الذُّنُوْبِ وَلَا حَوْلَ وَلَا قُوَّةَ اِلَّا بِاﷲِ الْعَلِيِّ الْعَظِيْمِِ",
                    "I seek forgiveness from ALLAH, my Lord, from every sin I committed knowingly or unknowingly, secretly or openly, and I turn towards Him from the sin that I know and from the sin that I do not know, Certainly You (O ALLAH!), You (are) the knower of the hidden things and the Concealer (of) the mistakes and the Forgiver (of) the sins. And (there is) no power and no strength except from ALLAH, the Most High, the Most Great."
                ),
                QalmaModel(
                    "6th Kalma",
                    "اَللّٰهُمَّ اِنِّيْ اَعُوْذُ بِکَ مِنْ اَنْ اُشْرِکَ بِکَ شَيْئًا وَّاَنَا اَعْلَمُُ بِهِ وَاَسْتَغْفِرُکَ لِمَا لَآ اَعْلَمُ بِهِ تُبْتُ عَنْهُ وَتَبَرَّاْتُ مِنَ الْکُفْرِ وَالشِّرْکِ وَالْکِذْبِ وَالْغِيْبَةِ وَالْبِدْعَةِ وَالنَّمِيْمَةِ وَالْفَوَاحِشِ وَالْبُهْتَانِ وَالْمَعَاصِيْ کُلِّهَا وَاَسْلَمْتُ وَاَقُوْلُ لَآ اِلٰهَ اِلَّا اﷲُ مُحَمَّدٌ رَّسُوْلُ اﷲِِ",
                    "O ALLAH! I seek refuge in You from that I should not join any partner with You, and I have knowledge of it. I seek Your forgiveness from that which I do not know. I repent from it (ignorance), and I reject disbelief and joining partners with You and of falsehood and slandering and innovation in religion and tell-tales and evil deeds and the blame and the disobedience, all of them. I submit to Your will, and I believe and declare: There is none worthy of worship except ALLAH and Muhammad (P.B.U.H) is His Messenger."
                )
            )
        }
    }


    suspend fun getQul(): List<QulModel> {
        return withContext(Dispatchers.IO) {
            listOf(
                QulModel(
                    "سورت الكٰفِرُونَۙ",
                    "بِسمِ ٱللَّهِ ٱلرَّحمَٰنِ ٱلرَّحِيمِ\n" +
                            "(1)قُلْ يَآ اَيُّـهَا الْكَافِرُوْنَ(2) لَآ اَعْبُدُ مَا تَعْبُدُوْنَ(3) وَلَآ اَنْتُـمْ عَابِدُوْنَ مَآ اَعْبُدُ(4) وَلَآ اَنَا عَابِدٌ مَّا عَبَدْتُّـمْ(5) وَلَآ اَنْـتُـمْ عَابِدُوْنَ مَآ اَعْبُدُ(6) لَكُمْ دِيْنُكُمْ وَلِىَ دِيْنِ\nِ",
                    " اور جس (خدا) کی میں عبادت کرتا ہوں اس کی تم عبادت نہیں کرتے  اور( میں پھر کہتا ہوں کہ) جن کی تم پرستش کرتے ہوں ان کی میں پرستش کرنے والا نہیں ہوں  اور نہ تم اس کی بندگی کرنے والے (معلوم ہوتے) ہو جس کی میں بندگی کرتا ہوں  تم اپنے دین پر میں اپنے دین پر",
                    "In the name of Allah, The Most Gracious and The Most Merciful\n" +
                            " Say: O disbelievers! I worship not that which ye worship; Nor worship ye that which I worship. And I shall not worship that which ye worship. Nor will ye worship that which I worship. Unto you your religion, and unto me my religion.\n"
                ), QulModel(
                    "سورت ٱلفَلَقَِۙ",
                    "بِسمِ ٱللَّهِ ٱلرَّحمَٰنِ ٱلرَّحِيمِ\n" +
                            "(1)قُل أَعُوذُ بِرَبِّ ٱلفَلَقِ (2)مِن شَرِّ مَا خَلَقَ (3)وَمِن شَرِّ غَاسِقٍ إِذَا وَقَبَ (4) وَمِن شَرِّ ٱلنَّفَّٰثَٰتِ فِي ٱلعُقَدِ (5)وَمِن شَرِّ حَاسِدٍ إِذَا حَسَدَ\nَِ",
                    "اللہ کے نام سے جو بڑا مہربان اور خاص رحم کرنے والا ہے۔ کہو، میں صبح کے رب کی پناہ مانگتا ہوں۔ اس چیز کے شر سے جو اس نے پیدا کی۔ اور اندھیرے کے شر سے جب وہ ٹھہر جائے اور گرہوں میں پھونکنے والوں کے شر سے۔ اور حسد کرنے والے کے شر سے جب وہ حسد کرے",
                    " In the name of Allah, The Most Gracious and The Most Merciful\n" +
                            "In the name of Allah, the Entirely Merciful, the Especially Merciful. Say, “I seek refuge in the Lord of daybreak. From the evil of that which He created. And from the evil of darkness when it settles. And from the evil of the blowers in knots. And from the evil of an envier when he envies.\n"
                ), QulModel(
                    "سورۃ الاخلاصَۙ",
                    "بِسمِ ٱللهِ ٱلرَّحمَٰنِ ٱلرَّحِيم\n" +
                            " (1)قُلْ هُوَ اللّـٰهُ اَحَدٌ(2) اَللَّـهُ الصَّمَدُ(3) لَمْ يَلِدْ وَلَمْ يُوْلَدْ(4) وَلَمْ يَكُنْ لَّـهٝ كُفُوًا اَحَدٌ \n",
                    "کہو کہ وہ (ذات پاک جس کا نام) الله (ہے) ایک ہے  معبود برحق جو بےنیاز ہے  نہ کسی کا باپ ہے اور نہ کسی کا بیٹا  اور کوئی اس کا ہمسر نہیں",
                    "In the name of Allah, The Most Gracious and The Most Merciful\n" +
                            "Say: He is Allah, the One! Allah, the eternal Besought of all! He begetteth not nor was begotten. And there is none comparable unto Him.\n"
                ), QulModel(
                    "سورت الناس َۙ",
                    "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّحِیْمِ\n" +
                            "(1)قُلْ اَعُوْذُ بِرَبِّ النَّاسِ(2) مَلِكِ النَّاسِ(3) اِلٰـهِ النَّاسِ(4) مِنْ شَرِّ الْوَسْوَاسِ الْخَنَّاسِ(5) اَلَّـذِىْ يُوَسْوِسُ فِىْ صُدُوْرِ النَّاسِ(6) مِنَ الْجِنَّـةِ وَالنَّاسِ  \n",
                    "کہو کہ میں لوگوں کے پروردگار کی پناہ مانگتا ہوں-  (یعنی) لوگوں کے حقیقی بادشاہ ک لوگوں کے معبود برحق کی  (شیطان) وسوسہ انداز کی برائی سے جو (خدا کا نام سن کر) پیچھے ہٹ جاتا ہے جو لوگوں کے دلوں میں وسوسے ڈالتا ہے وہ جنّات میں سے (ہو) یا انسانوں میں سے",
                    "Merciful\n" +
                            "(1) Say, “I seek refuge in the Lord of mankind, (2) The Sovereign of mankind. (3) The God of mankind,\n" +
                            "(4) From the evil of the retreating whisperer – (5) Who whispers [evil] into the breasts of mankind \n" +
                            "(6) From among the jinn and mankind.”\n"
                )
            )
        }

    }
}