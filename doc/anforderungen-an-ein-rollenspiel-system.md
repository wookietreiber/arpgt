% Anforderungen an ein Rollenspiel-System
% Richard Lange; Christian Krause
% \today


# Allgemein

**Realisierung**
:   Bei einer Realisierung handelt es sich um einen Regelkatalog, welcher die in diesem Dokument
    beschriebenen Anforderungen vollständig erfüllt. Eine Realisierung kann auch im Baukastenprinzip
    einzelne Regelbereiche in mehreren Varianten anbieten, diese müssen allerdings untereinander
    kompatibel und damit frei austauschbar sein.

**Regelauswahl**
:   Auswahl von Varianten (Baukastenelemente) einer Realisierung.

    Verschiedene Regelauswahlen können für verschiedene Kampagnen oder Heldengruppen verwendet
    werden.

**Basisregeln**
:   Die Regelauswahl mit den einfachsten / der geringstmöglichen Anzahl an Regeln.

    Helden, welche anhand der Basisregeln erstellt wurden, müssen mit allen möglichen Regelauswahlen
    kompatibel sein.

*Heldenkonzepte sollten sich ohnehin an den Basisregeln orientieren, womit sichergestellt werden
soll, dass Helden innerhalb einer Realisierung kompatibel zu allen Regelauswahlen sind.*


# Werte

**Attribut**
:   körperliche, geistige oder soziale Vorraussetzung

**Talent**
:   erlernte Fähigkeit

**Metatalent**
:   Talent, welches nicht erlernt ist, sondern sich aus anderen Talenten zusammensetzt

Es gibt eine festgelegte Anzahl von Attributen und eine beliebige Anzahl von Talenten.

Jedem Attribut und Talent ist ein Zahlenwert aus einem allgemein gültigem Wertebereich
zugeordnet. Jedem Zahlenwert ist eineindeutig eine Beschreibung / ein Niveau zugeordnet.


# Proben

**Probenwert**
:   Ein für eine Handlung relevanter Zahlenwert, welcher sich aus einem oder mehreren Attributs- oder
    Talentwerten und Modifikatoren zusammensetzt, z.B.
    [verfassungsabhängige Modifikatoren](#Verfassung).

**Probe**
:   Eine *Probe* verknüpft einen Probenwert mit einem Zufallselement, um eine eindeutige Aussage
    über den Erfolg einer Handlung zu machen.

    In einer Realisierung gibt es genau einen regeltechnischen Mechanismus für Proben.

*Das Resultat einer Probe kann unter Umständen auch lauten "keine Veränderung" ("Unentschieden",
gerade bei vergleichenden Proben).*

**Qualität einer Handlung**
:   Die Qualität einer Handlung ist derjenige Zahlenwert, um welchen der Probenwert des Agierenden
    verringert werden könnte, so dass er immer noch erfolgreich gewesen wäre.

    Die Qualität kann damit erst nach dem Zufallselement festgestellt werden.

    Es ist auch eine negative Qualität möglich, welche eine Aussage über die Schwere oder Art des
    Scheiterns einer Handlung machen kann.

**Probenschwierigkeit**
:   Die *Probenschwierigkeit* ist ein Zahlenwert, welcher ausdrückt, wie schwierig die zu probende
    Handlung ist. Bei vergleichenden Proben ist die Qualität der Probe des Reagierenden die
    Schwierigkeit der Probe des Agierenden.

Die Erfolgswahrscheinlichkeit einer Probe hängt von der Differenz zwischen Probenwert und
Probenschwierigkeit ab, Proben sind daher immer relativ, nie absolut. Die Erfolgswahrscheinlichket
einer Probe beträgt bei gegebener Differenz Δ = Wert - Schwierigkeit:

   Differenz       p  Beschreibung
  -----------  -----  ---------------
    Δ << 0        0%  unschaffbar
    Δ <  0       ...  schwierig
    Δ =  0       50%  herausfordernd
    Δ >  0       ...  leicht
    Δ >> 0      100%  trivial


## Konflikte

Ein *Konflikt* stellt die regeltechnische Bewältigung einer spezifischen Konfrontation mehrerer
Akteure dar, z.B. Kampf, Streit ums Essen, Blickduell, usw.-

Ein Konflikt birgt immer das Risiko von Änderungen der [Verfassung](#Verfassung).

**Dominanz**
:   Bei der *Dominanz* handelt es sich um eine Skala, welche beschreibt, welcher von zwei Akteuren
    gerade wie sehr die Oberhand hat. Die Dominanz äußert sich regeltechnisch in einer Beeinflussung
    von Probenwerten durch einen Modifikator.

**Konfliktprobe**
:   Eine *Konfliktprobe* ist eine vergleichende Probe, deren Ziel eine Veränderung der Dominanz oder
    der Verfassung des Kontrahenten ist.

    Bei einer Konfliktprobe gibt es, unabhängig von der Fähigkeitsdifferenz der Akteure, keine
    nullprozentige oder hunderprozentige Erfolgswahrscheinlichkeit. Ein geringes, aber nicht
    vernachlässigbares Risiko ist immer gegeben.

    Ein Konflikt beinhaltet hinreichend viele Konfliktproben, um, gemessen an den Fähigkeiten der
    Akteure, grundsätzlich vorhersehbar zu sein.

### Konfliktlösung

Ein hinreichend hohes Dominanzniveau führt automatisch zur Lösung des Konfliktes, da ein extrem
hoher Dominanzmodifikator einen garantierten Erfolg einer Konfliktprobe erzwingen kann.

*Ist man beispielsweise in einem Kampf so weit in die Enge getrieben worden, dass man aufgeben muss,
ist der Modifikator durch die Dominanz des Gegenübers so ungünstig, dass man seine Konfliktprobe(n)
nicht mehr schaffen kann.*

### Akteure

Bei einem *Akteur* muss es sich nicht zwangsweise um eine einzelne Person handeln.

*mehrere im Kampf Formation, kann diese Gruppe als ein Akteur angesehen werden. anderes Beispiel bei
mehreren Diskussionspartnern bei einer Überzeugungsarbeit*

Bei mehr als zwei Akteuren gibt es zwischen jeweils zwei Akteuren einen Dominanzwert.

*Eine mögliche Realisierung wäre zum Beispiel eine "Oberhand-Höhenkarte", bei der jedem Akteur ein
Zahlenwert zugeordnet wird, wobei sich die Dominanz zwischen zwei Akteuren aus der Differenz der
jeweiligen Werte ergibt.*

### Konflikt-Systeme

Eine Realisierung kann verschiedene Konflikt-Systeme anbieten, bspw. zur Lösung von Kampfhandlungen,
politischen Diskussionen oder geistigen Duellen.

Ein Konflikt-System ist dazu in der Lage, verschiedene Taktiken / Herangehensweisen abzubilden
([Feats](#Feats)).

Ein Konflikt-System ermöglicht es, die Art des Konfliktes fließend zu variieren, wobei die Dominanz
dabei übertragen werden kann.

*Indem man einen in die Enge getriebenen Gegner dazu auffordert, aufzugeben, wandelt man einen
körperlichen Konflikt in einen geistigen oder sozialen um.*


# Verfassung {#Verfassung}

Es gibt eine körperliche, geistige und soziale Verfassung, wie bei Attributen.

Jede Veränderung der Verfassung kann (kaskadierend) Zustandsänderungen nach sich ziehen.

Es gibt verfassungsabhängige Modifikatoren auf [Proben](#Proben).

Die Verfassung definiert sich aus der Summe der vorhandenen Verletzungen und Zustände.

**Verletzungen**
:   Verletzungen können die körperliche, geistige oder soziale Verfassung betreffen. Sie können in
    Kategorien eingeordnet werden. Die konkrete Einordnung einer Verletzung kann von verschiedenen
    Faktoren abhängig sein.

    *Leichte* Verletzungen können durch Erholung (Schlaf) regeneriert werden. *Schwere* Verletzungen
    können nur durch professionelle Behandlung regeneriert werden.

**Zustand**
:   Ein Realisierung kann verschiedene Zustände definieren. Ein Zustand hat, neben den
    verfassungsabhängigen Modifikatoren, weitere festgelegte Auswirkungen auf einen Charakter.

    Ob und wann ein Zustand abklingt, hängt vom konkreten Zustand, bzw. der Realisierung ab.

  Zustand                    Beschreibung
  -----------                ------------
  Adrenalinschub             positive Modifikatoren im angespannten Zustand
  medizinischer Schock       negative körperliche Modifikatoren durch starken
                             Blutverlust
  akute Belastungsreaktion   negative geistige Modifikatoren durch extreme
                             psychische Belastungen
  Handlungsfähigkeit         zu bestimmten Arten von Handlungen nicht mehr in
                             der Lage


# Umgang mit übernatürlichen Fähigkeiten

Die Kosten der Anwendung übernatürlicher Fähigkeiten werden über eine Veränderung der Verfassung
ausgedrückt. Es gibt keine übernatürliche Ressource, wie Astralpunkte, Mana, Karmaenergie, etc.

funktioniert wie talente


# Generierung und Steigerung

Generierung und Steigerung laufen nach dem gleichen Prinzip ab und verwenden die gleiche Ressource.

Generierung und Steigerung sind frei. Es gibt keine Pakete und keine Rabatte. Steigerungen sind
assoziativ $(a + b) + c = a + (b + c)$ und kommutativ $a + b = b + a$.

*Es gibt keinen billigeren Weg zu steigern.*

(Jedem Charakter wird eine feste Anzahl von frei wählbaren Vor- und Nachteilen zugeordnet.)

*alles andere: Charakter ausspielen + Flags*



# bla

Liste von Werten nach Schema F wie oben, charakterisiert Beziehung zu Umwelt, zur Generierung mit SP
festgelegt, dann ändert sich nur als Resultat von dem was in abenteuren passiert



# Feats {#Feats}

- ausschließlich zum Ausdruck von Taktiken bei Konflikten
- du kannst die nennen wie de willst, aber es muss einen festen wechselkurs geben (vergleichbarkeit)
  und es muss sich mit folgenden dingen auseinandersetzen
  - verfassung inklusive zustand
  - modifikator f. konfliktprobe
  - dominanz

