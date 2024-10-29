package racingcar.reducer

interface Reducer<Mutation, State> {
    operator fun invoke(mutation: Mutation, state: State): State
}