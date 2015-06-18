:- use_module(library(regex)).
:- dynamic word/2.


sentence -->
    {retractall(word(_, _))},
	subject,
	verb,
	object.

sentence -->
    {retractall(word(_, _))},
	subject,
	object,
	verb.

sentence -->
    {retractall(word(_, _))},
	verb,
	subject,
	object.

sentence -->
    {retractall(word(_, _))},
	subject,
	substantive_verb,
	adjective.

subject -->
	article,
	adjective,
	noun.

subject -->
	personal_pronoun.

verb -->
	adverb,
	verb.

object -->
	article,
	adjective_acc,
	noun_acc.

object -->
	personal_pronoun_acc.

adjective([Word|X], X) :-
	Word =~ '.+a$',
    assert(word(Word, 'melléknév, egyesszám, alanyeset')).

adjective([Word|X], X) :-
	Word =~ '.+aj$',
    assert(word(Word, 'melléknév, többesszám, alanyeset')).

adjective --> [].

adjective_acc([Word|X], X) :-
	Word =~ '.+an$',
    assert(word(Word, 'melléknév, egyesszám, tárgyeset')).

adjective_acc([Word|X], X) :-
	Word =~ '.+ajn$',
    assert(word(Word, 'melléknév, többesszám, tárgyeset')).

adjective_acc --> [].

adverb([Word|X], X) :-
	Word =~ '.+e$',
    assert(word(Word, 'határozószó')).

article --> [la], {assert(word('la', 'határozott névelő'))}.
article --> [].

infinitive([Word|X], X) :-
	Word =~ '.+i$',
    assert(word(Word, 'főnévi igenév')).

noun([Word|X], X) :-
	Word =~ '.+o$',
    assert(word(Word, 'főnév, egyesszám, alanyeset')).

noun([Word|X], X) :-
	Word =~ '.+oj$',
    assert(word(Word, 'főnév, többesszám, alanyeset')).

noun_acc([Word|X], X) :-
	Word =~ '.+on$',
    assert(word(Word, 'főnév, egyesszám, tárgyeset')).

noun_acc([Word|X], X) :-
	Word =~ '.+ojn$',
    assert(word(Word, 'főnév, többesszám, tárgyeset')).

noun_acc --> [].

personal_pronoun --> [mi], {assert(word('mi', 'személyes névmás (E/1), alanyeset'))}.
personal_pronoun --> [vi], {assert(word('vi', 'személyes névmás (/2), alanyeset'))}.
personal_pronoun --> [li], {assert(word('li', 'személyes névmás (E/3), hímnem, alanyeset'))}.
personal_pronoun --> [ŝi], {assert(word('ŝi', 'személyes névmás (E/3), nőnem, alanyeset'))}.
personal_pronoun --> [ĝi], {assert(word('ĝi', 'személyes névmás (E/3), semlegesnem, alanyeset'))}.
personal_pronoun --> [ni], {assert(word('ni', 'személyes névmás (T/1), alanyeset'))}.
personal_pronoun --> [ili], {assert(word('ili', 'személyes névmás (T/3), alanyeset'))}.

personal_pronoun_acc --> [min], {assert(word('min', 'személyes névmás (E/1), tárgyeset'))}.
personal_pronoun_acc --> [vin], {assert(word('vin', 'személyes névmás (/2), tárgyeset'))}.
personal_pronoun_acc --> [lin], {assert(word('lin', 'személyes névmás (E/3), hímnem, tárgyeset'))}.
personal_pronoun_acc --> [ŝin], {assert(word('ŝin', 'személyes névmás (E/3), nőnem, tárgyeset'))}.
personal_pronoun_acc --> [ĝin], {assert(word('ĝin', 'személyes névmás (E/3), semlegesnem, tárgyeset'))}.
personal_pronoun_acc --> [nin], {assert(word('nin', 'személyes névmás (T/1), tárgyeset'))}.
personal_pronoun_acc --> [ilin], {assert(word('ilin', 'személyes névmás (T/3), tárgyeset'))}.

substantive_verb --> [estas], {assert(word('estas', 'létige, jelen idő'))}.
substantive_verb --> [estis], {assert(word('estis', 'létige, múlt idő'))}.
substantive_verb --> [estos], {assert(word('estos', 'létige, jövő idő'))}.

verb([Word|X], X) :-
	Word =~ '.+as$',
    assert(word(Word, 'ige, jelen idő')).

verb([Word|X], X) :-
	Word =~ '.+is$',
    assert(word(Word, 'ige, múlt idő')).

verb([Word|X], X) :-
	Word =~ '.+os$',
    assert(word(Word, 'ige, jövő idő')).