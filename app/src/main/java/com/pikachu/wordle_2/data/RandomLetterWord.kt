package com.pikachu.wordle_2.data

// This should be more general, like some kind of offline API
object RandomLetterWord {
    // List of most common 4 letter words from: https://7esl.com/4-letter-words/
    private const val fourLetterWords =
        "Area,Army,Baby,Back,Ball,Band,Bank,Base,Bill,Body,Book,Call,Card,Care,Case,Cash,City,Club,Cost,Date,Deal,Door,Duty,East,Edge,Face,Fact,Farm,Fear,File,Film,Fire,Firm,Fish,Food,Foot,Form,Fund,Game,Girl,Goal,Gold,Hair,Half,Hall,Hand,Head,Help,Hill,Home,Hope,Hour,Idea,Jack,John,Kind,King,Lack,Lady,Land,Life,Line,List,Look,Lord,Loss,Love,Mark,Mary,Mind,Miss,Move,Name,Need,News,Note,Page,Pain,Pair,Park,Part,Past,Path,Paul,Plan,Play,Post,Race,Rain,Rate,Rest,Rise,Risk,Road,Rock,Role,Room,Rule,Sale,Seat,Shop,Show,Side,Sign,Site,Size,Skin,Sort,Star,Step,Task,Team,Term,Test,Text,Time,Tour,Town,Tree,Turn,Type,Unit,User,View,Wall,Week,West,Wife,Will,Wind,Wine,Wood,Word,Work,Year,Bear,Beat,Blow,Burn,Call,Care,Cast,Come,Cook,Cope,Cost,Dare,Deal,Deny,Draw,Drop,Earn,Face,Fail,Fall,Fear,Feel,Fill,Find,Form,Gain,Give,Grow,Hang,Hate,Have,Head,Hear,Help,Hide,Hold,Hope,Hurt,Join,Jump,Keep,Kill,Know,Land,Last,Lead,Lend,Lift,Like,Link,Live,Look,Lose,Love,Make,Mark,Meet,Mind,Miss,Move,Must,Name,Need,Note,Open,Pass,Pick,Plan,Play,Pray,Pull,Push,Read,Rely,Rest,Ride,Ring,Rise,Risk,Roll,Rule,Save,Seek,Seem,Sell,Send,Shed,Show,Shut,Sign,Sing,Slip,Sort,Stay,Step,Stop,Suit,Take,Talk,Tell,Tend,Test,Turn,Vary,View,Vote,Wait,Wake,Walk,Want,Warn,Wash,Wear,Will,Wish,Work,Able,Back,Bare,Bass,Blue,Bold,Busy,Calm,Cold,Cool,Damp,Dark,Dead,Deaf,Dear,Deep,Dual,Dull,Dumb,Easy,Evil,Fair,Fast,Fine,Firm,Flat,Fond,Foul,Free,Full,Glad,Good,Grey,Grim,Half,Hard,Head,High,Holy,Huge,Just,Keen,Kind,Last,Late,Lazy,Like,Live,Lone,Long,Loud,Main,Male,Mass,Mean,Mere,Mild,Nazi,Near,Neat,Next,Nice,Okay,Only,Open,Oral,Pale,Past,Pink,Poor,Pure,Rare,Real,Rear,Rich,Rude,Safe,Same,Sick,Slim,Slow,Soft,Sole,Sore,Sure,Tall,Then,Thin,Tidy,Tiny,Tory,Ugly,Vain,Vast,Very,Vice,Warm,Wary,Weak,Wide,Wild,Wise,Zero,Ably,Afar,Anew,Away,Back,Dead,Deep,Down,Duly,Easy,Else,Even,Ever,Fair,Fast,Flat,Full,Good,Half,Hard,Here,High,Home,Idly,Just,Late,Like,Live,Long,Loud,Much,Near,Nice,Okay,Once,Only,Over,Part,Past,Real,Slow,Solo,Soon,Sure,That,Then,This,Thus,Very,When,Wide"

    private const val fiveLetterWords =
                "About,After,Ahead,Allow,Alone,Along,Among,Angry,Ankle,Apple,Apply,Arrow,Audio,Bacon,Baker,Basis,Beach,Belly,Bench,Berry,Black,Blame,Blood,Board,Brain,Brand,Break,Brief,Brown,Build,Cabin,Cable,Cakey,Camel,Candy,Capac,Cargo,Cheek,Chest,Cigar,Circu,Civil,Clean,Clear,Click,Clock,Close,Cloth,Cloud,Coast,Color,Comed,Comit,Compl,Concl,Cooly,Couch,Could,Court,Crash,Cream,Creep,Crime,Cross,Crush,Crush,Cubic,Curve,Cycle,Daily,Dance,Dared,Darky,Deadl,Death,Debut,Decad,Decay,Decor,Delay,Deliv,Dense,Depot,Depth,Desig,Desir,Despa,Destr,Detec,Devel,Devic,Devin,Devot,Dicta,Diehl,Diffe,Dimen,Dimly,Dinne,Direc,Direl,Dirge,Disab,Disas,Disco,Disme,Displ,Dispu,Disse,Diver,Diver,Divid,Divin,Divis,Dodge,Doggy,Dozen,Drain,Dream,Dress,Drive,Drive,Dummy,Duple,Dusty,Dutch,Eager,Eagle,Early,Earns,Earth,Earth,EastE,Edgey,Ediab,Edito,Edmon,Elbow,Elder,Elect,Elect,Elegy,Eleph,Eleva,Elimi,Elmhu,Embry,Emerge,Empir,Emplo,Empow,Empty,Enfor,Engag,Engin,Engli,Enoug,Enter,Entir,Entit,Envir,Erase,Erect,Esper,Ether,Ethic,Evict,Evide,Evil,Exile,Expan,Expec,Exper,Exper,Explo,Expor,Exten,Extre,Extra,Extra,Faile,Fairy,Famou,Farme,Fasci,Fashi,Faste,Fathe,Favor,Fears,Featu,Feeli,Fello,Femal,Fence,Fiest,Films,Firml,Fitte,Flash,Fleet,Flesh,Fligh,Fligh,Flowe,Flyin,Focu,Folde,Force,Forme,Formu,Forte,Forth,Forty,Found,Frame,Franc,Fraud,Fresh,Frien,Frost,Funny,Futur,Garde,Gathe,Gende,Ghost,Giggl,Glass,Glovi,Glutc,GoalK,Golfe,Gover,Gover,Grade,Gramm,Grand,Grant,Graze,Great,Greet,Greed,Groan,Gross,Groun,Growt,Guard,Guild,Guilt,Habit,Hadno,Hanov,Happi,Harve,Haven,Hazle,Headi,Healt,Heart,Heave,Heave,Heavi,Hemmi,Henry,Herit,Heroe,Hidde,Hills,Histo,Holde,Holid,Holly,Hones,Hooke,Hopki,Horne,Hospi,Housi,Hunte,Hydro,Ideal,Impac,Impre,Impos,Impul,Injur,Inqui,Insid,Inspe,Inspo,Insta,Insti,Insti,Insti,Instr,Instr,Instr,Inter,Inter,Inter,Inter,Inter,Inter,Inter,Intui,Inven,Inves,Irwin,Issac,Jacob,Jake,James,Janua,Jared,Jason,Jesse,Jimmy,Johnn,Jorda,Josep,Joshu,Journ,Judyt,Julie,Jumps,Kathy,Kelly,Kelly,Kenneth,Kevin,Kiera,Kimbe,Krist,Krist,Krist,Kyoth,Lands,Larso,Late,Latin,Launc,Lawsu,Learn,Leech,Legal,Lewis,Light,Lingr,Lisaw,Locat,Longe,Looku,Loqui,Loose,Lough,Lucil,Lunac,Macho,Madne,Maids,Malec,Mania,Manua,Marie,Marke,Marle,Marri,Marri,Marri,Marry,Marve,Marys,Masqu,Maste,Maste,Match,Matri,Matte,Mauri,Mayfl,Mayfl,Mediu,Melis,Memor,Metro,Micke,Milit,Mindf,Minio,Minis,Miracl,Mispl,Misse,Mista,Mixtu,Moder,Moder,Moder,Monit,Monke,Monum,Moreo,Moroc,Morti,Mount,Mount,Mourn,Mouth,Moves,Movie,Movie,Muffi,Muffl,Multi,Murde,Murra,Murre,Muscl,Mutan,Mutua,Mytho,Naked,Nancy,Naomi,Natur,Naval,Nearl,Neigh,Nervi,Nerve,Newbo,Newsp,Niche,Night,Noble,Noisy,Notab,Notic,Nucle,Numbe,Numbe,Numbe,Nurtu,Nutty,Obeyi,Obser,Obsti,Oceal,Oftok,Oftok,OlivO,Opera,Opera,Oplin,OrigiPacky,Paddy,Paged,Pager,Pages,Paini,Paint,Palma,Panam,Paper,Paris,Parks,Party,Pastr,Patch,Patio,Paula,Paulo,Pause,Peace,Peach,Pearl,Peopl,Peppe,Peril,Perso,Perth,Peter,Phase,Philp,Phone,Photo,Pilot,Piney,Pinky,Pizza,Place,Plain,Plana,Plane,Plaza,Plumb,Plump,Plush,Point,Polis,Polka,Polly,Porch,Pound,Power,Prawn,Prece,Prese,Press,Priam,Price,Prick,Pride,Prime,Print,Prior,Profi,Progr,Prope,Prose,Proud,Provo,Prows,Proxy,Pryer,Puert,Puffy,Punch,Pupil,Puppy,Purch,Pures,Purpl,Pushy,Pyxis,Quart,Quill,Quote,Racin,Radio,Rains,Raise,Rally,Ramen,Ranch,Randy,Ranke,Ratio,Raven,Raver,Raves,Reach,Reads,Ready,Realm,Reaso,Recal,Recei,Recent,Recom,Recor,Recou,Recov,Reddi,Redir,Reduc,Reedi,Reeke,Refer,Refil,Refin,Refle,Refoe,Refor,Refra,Refug,Regai,Regar,Regim,Regio,Regis,Rehab"

    // Returns a list of four letter words as a list
    private fun getAllFourLetterWords(): List<String> {
        return fourLetterWords.split(",")
    }

    private fun getAllFiveLetterWords(): List<String> {
        return fiveLetterWords.split(",")
    }

    // Returns a random four letter word from the list in all caps
    fun getRandomLetterWord(wordSize: Int = 4): String {
        return when (wordSize) {
            4 -> {
                val allWords = getAllFourLetterWords()
                val randomNumber = (0..allWords.size).shuffled().last()
                allWords[randomNumber].uppercase()
            }
            5 -> {
                val allWords = getAllFiveLetterWords()
                val randomNumber = (0..allWords.size).shuffled().last()
                allWords[randomNumber].uppercase()
            }
            else -> {
                ""
            }
        }
    }
}