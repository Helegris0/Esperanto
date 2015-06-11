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
	substantive_verb,
	adjective.

subject -->
	article,
	adjective,
	noun.

subject -->
	personal_pronoun.

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

personal_pronoun([Word|X], X) :-
	Word = 'mi',
    assert(word(Word, 'személyes névmás (E/1), alanyeset')).

personal_pronoun([Word|X], X) :-
	Word = 'vi',
    assert(word(Word, 'személyes névmás (E/2), alanyeset')).

personal_pronoun([Word|X], X) :-
	Word = 'li',
    assert(word(Word, 'személyes névmás (E/3), hímnem, alanyeset')).

personal_pronoun([Word|X], X) :-
	Word = 'ŝi',
    assert(word(Word, 'személyes névmás (E/3), nőnem, alanyeset')).

personal_pronoun([Word|X], X) :-
	Word = 'ĝi',
    assert(word(Word, 'személyes névmás (E/3), semlegesnem, alanyeset')).

personal_pronoun([Word|X], X) :-
	Word = 'ni',
    assert(word(Word, 'személyes névmás (T/1), alanyeset')).

personal_pronoun([Word|X], X) :-
	Word = 'vi',
    assert(word(Word, 'személyes névmás (T/2), alanyeset')).

personal_pronoun([Word|X], X) :-
	Word = 'ili',
    assert(word(Word, 'személyes névmás (T/3), alanyeset')).
	
personal_pronoun_acc([Word|X], X) :-
	Word = 'min',
    assert(word(Word, 'személyes névmás (E/1), tárgyeset')).

personal_pronoun_acc([Word|X], X) :-
	Word = 'vin',
    assert(word(Word, 'személyes névmás (E/2), tárgyeset')).

personal_pronoun_acc([Word|X], X) :-
	Word = 'lin',
    assert(word(Word, 'személyes névmás (E/3), hímnem, tárgyeset')).

personal_pronoun_acc([Word|X], X) :-
	Word = 'ŝin',
    assert(word(Word, 'személyes névmás (E/3), nőnem, tárgyeset')).

personal_pronoun_acc([Word|X], X) :-
	Word = 'ĝin',
    assert(word(Word, 'személyes névmás (E/3), semlegesnem, tárgyeset')).

personal_pronoun_acc([Word|X], X) :-
	Word = 'nin',
    assert(word(Word, 'személyes névmás (T/1), tárgyeset')).

personal_pronoun_acc([Word|X], X) :-
	Word = 'vin',
    assert(word(Word, 'személyes névmás (T/2), tárgyeset')).

personal_pronoun_acc([Word|X], X) :-
	Word = 'ilin',
    assert(word(Word, 'személyes névmás (T/3), tárgyeset')).

substantive_verb([Word|X], X) :-
	Word = 'estas',
    assert(word(Word, 'létige, jelen idő')).

substantive_verb([Word|X], X) :-
	Word = 'estis',
    assert(word(Word, 'létige, múlt idő')).

substantive_verb([Word|X], X) :-
	Word = 'estos',
    assert(word(Word, 'létige, jövő idő')).

verb([Word|X], X) :-
	Word =~ '.+as$',
    assert(word(Word, 'ige, jelen idő')).

verb([Word|X], X) :-
	Word =~ '.+is$',
    assert(word(Word, 'ige, múlt idő')).

verb([Word|X], X) :-
	Word =~ '.+os$',
    assert(word(Word, 'ige, jövő idő')).